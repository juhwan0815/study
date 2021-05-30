package juhwan.study.javatest;

import com.tngtech.archunit.junit.AnalyzeClasses;
import com.tngtech.archunit.junit.ArchTest;
import com.tngtech.archunit.lang.ArchRule;

import static com.tngtech.archunit.lang.syntax.ArchRuleDefinition.classes;
import static com.tngtech.archunit.lang.syntax.ArchRuleDefinition.noClasses;
import static com.tngtech.archunit.library.dependencies.SlicesRuleDefinition.slices;

@AnalyzeClasses(packagesOf = App.class) // 클래스가 있는 패키지 지정
public class ArchTests {

    @ArchTest
    ArchRule controllerClassRule = classes().that().haveSimpleNameEndingWith("Controller")
            .should().accessClassesThat().haveSimpleNameEndingWith("Service")
            .orShould().accessClassesThat().haveSimpleNameEndingWith("Repository");

    // ..domain.. 패키지에 있는 클래스는 ..study.., ..member.., ..domain에서 참조 가능.
    @ArchTest
    ArchRule domainPackageRule = classes().that().resideInAPackage("..domain..")
            .should().onlyBeAccessed().byClassesThat()
            .resideInAnyPackage("..study..","..member..","..domain..");


    // (반대로) ..domain.. 패키지는 ..member.. 패키지를 참조하지 못한다.
    @ArchTest
    ArchRule memberPackageRule = noClasses().that().resideInAPackage("..domain..")
            .should().accessClassesThat()
            .resideInAPackage("..member..");

    @ArchTest
    ArchRule studyPackageRule = noClasses().that().resideOutsideOfPackage("..study..")
            .should().accessClassesThat()
            .resideInAPackage("..study..");

    @ArchTest
    ArchRule freeOfCycles = slices().matching("..javatest.(*)..")
            .should().beFreeOfCycles();



}
