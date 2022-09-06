package com.optimagrowth.license.model;


import lombok.Data;
import org.springframework.hateoas.RepresentationModel;

/**
 * 라이센스 정보를 보관하는 POJO
 */
@Data
public class License extends RepresentationModel<License> {

    private int id;

    private String licenseId;

    private String description;

    private String organizationId;

    private String productName;

    private String licenseType;
}
