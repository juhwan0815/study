package spring.study.teststudy;

import com.tngtech.archunit.core.domain.JavaClasses;
import com.tngtech.archunit.core.importer.ClassFileImporter;
import com.tngtech.archunit.junit.AnalyzeClasses;
import com.tngtech.archunit.junit.ArchTest;
import com.tngtech.archunit.lang.ArchRule;
import org.junit.internal.Classes;
import org.junit.jupiter.api.Test;

import static com.tngtech.archunit.lang.syntax.ArchRuleDefinition.classes;
import static com.tngtech.archunit.lang.syntax.ArchRuleDefinition.noClasses;
import static com.tngtech.archunit.library.dependencies.SlicesRuleDefinition.slices;

@AnalyzeClasses(packagesOf = App.class)
public class ArchTests {

    @ArchTest
    ArchRule domainPackageRule = classes().that().resideInAPackage("..domain..")
            .should().onlyBeAccessed().byClassesThat()
            .resideInAnyPackage("..study..","..member..","..domain..");

    @ArchTest
    ArchRule memberPackageRule = noClasses().that().resideInAPackage("..domain..")
            .should().accessClassesThat().resideInAPackage("..member..");

    @ArchTest
    ArchRule studyPackageRule = noClasses().that().resideOutsideOfPackage("..study..")
            .should().accessClassesThat().resideInAPackage("..study..");

    @ArchTest
    ArchRule freeOfCycles = slices().matching("..teststudy.(*)..")
            .should().beFreeOfCycles();


}
