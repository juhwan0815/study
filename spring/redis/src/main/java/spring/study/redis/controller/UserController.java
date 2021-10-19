package spring.study.redis.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import spring.study.redis.common.CacheKey;
import spring.study.redis.domain.User;
import spring.study.redis.dto.UserCreateRequest;
import spring.study.redis.dto.UserUpdateRequest;
import spring.study.redis.repository.UserRepository;

@RestController
@RequiredArgsConstructor
@RequestMapping("redis")
public class UserController {

    private final UserRepository userRepository;

    /**
     * @Cacheable
     * Redis에 캐싱된 데이터가 있으면 반환하고 없으면 DB에서 조회한 다음 Redis에 캐시
     * 고정된 키 값 CacheKey.User와 유동적으로 변하는 userId를 가지고 키를 조합하여 캐시를 조회
     * 캐시 이름은 user::500 같이 ::으로 구분된 이름 저장
     * Result가 null이 아닌 경우만 처리
     * RedisCache에서 세팅한 expireTime=180초로 TTL이 설정
     */
    @Cacheable(value = CacheKey.USER, key = "#userId",unless = "#result == null")
    @GetMapping("/users/{userId}")
    public User findById(@PathVariable Long userId) {
        return userRepository.findById(userId).orElse(null);
    }

    @PostMapping("/users")
    public User createUser(@RequestBody UserCreateRequest request){
        return userRepository.save(User.createUser(request.getName(),request.getEmail(),request.getPassword()));
    }

    /**
     * @CachePut
     * Redis에 저장된 캐시 정보를 갱신, 저장된 캐시가 없을 경우엔 캐시를 생성
     * 파라미터로 넘어온 userId로 DB를 업데이트하고 userId와 고정키 키 값으로 조합된 캐시키로 캐시를 찾아내 갱신
     */
    @CachePut(value = CacheKey.USER,key = "#userId")
    @PutMapping("/users/{userId}")
    public User updateUser(@PathVariable Long userId,
                           @RequestBody UserUpdateRequest request){

        User findUser = userRepository.findById(userId).orElse(null);
        findUser.updateUser(request.getName(),request.getPassword());
        userRepository.save(findUser);

        return findUser;
    }

    /**
     * @CacheEvict : Redis에 저장된 캐시정보를 삭제
     * DB 데이터 삭제후 고정 키 값과 파라미터의 msrl로 캐시키를 조합하여 해당 캐시를 삭제
     */
    @CacheEvict(value = CacheKey.USER,key = "#userId")
    @DeleteMapping("/users/{userId}")
    public ResponseEntity deleteUser(@PathVariable Long userId){
        userRepository.deleteById(userId);
        return ResponseEntity.status(HttpStatus.OK).build();
    }
}