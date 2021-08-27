import axios from 'axios';

// 1. HTTP Request & Response 와 관련된 기본 설정
const config = {
    baseUrl: 'https://api.hnpwa.com/v0/',
}

// 2. API 함수들을 정리
function fetchNewsList() {
    return axios.get(`${config.baseUrl}news/1.json`);
}

function fetchJobsList() {
    return axios.get(`${config.baseUrl}jobs/1.json`);
}

async function fetchAskList() {
    try {
        return await axios.get(`${config.baseUrl}ask/1.json`);
    } catch (error) {
        console.log(error);
    }
}

async function fetchList(pageName) {
    try {
        return axios.get(`${config.baseUrl}${pageName}/1.json`)
    } catch (error) {
        console.log(error);
    }
}

async function fetchUserInfo(username) {
    try {
        return axios.get(`${config.baseUrl}user/${username}.json`);
    } catch (error) {
        console.log(error);
    }
}

async function fetchCommentItem(id) {
    try {
        return axios.get(`${config.baseUrl}item/${id}.json`);
    } catch (error) {
        console.log(error);
    }
}


export {
    fetchNewsList,
    fetchJobsList,
    fetchAskList,
    fetchUserInfo,
    fetchCommentItem,
    fetchList
}