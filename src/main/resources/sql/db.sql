CREATE DATABASE `assessment` DEFAULT CHARACTER SET utf8 COLLATE utf8_general_ci;

#用户
CREATE TABLE `user`
(
    `id`              VARCHAR(64) NOT NULL,
    `username`        VARCHAR(64) NOT NULL,
    `password`        VARCHAR(64) NOT NULL,
    `email`           VARCHAR(64) NOT NULL,
    `create_time`     DATETIME    NOT NULL,
    `last_login_time` DATETIME    NULL,
    `status`          INT         NOT NULL DEFAULT 0,
    `random_code`     VARCHAR(64) NOT NULL,
    PRIMARY KEY (`id`),
    UNIQUE (
            `random_code`
        )
) ENGINE = INNODB
  CHARACTER SET utf8
  COLLATE utf8_general_ci;

#模板
CREATE TABLE `template`
(
    `template_id`          VARCHAR(64)  NOT NULL,
    `description`          VARCHAR(512) NOT NULL,
    `template_name`        VARCHAR(64)  NOT NULL,
    `template_status`      INT          NOT NULL DEFAULT 0,
    `template_creator`     VARCHAR(64)  NOT NULL,
    `template_create_date` DATETIME     NOT NULL,
    PRIMARY KEY (`template_id`)
) ENGINE = INNODB
  CHARACTER SET utf8
  COLLATE utf8_general_ci;

#评估
CREATE TABLE `assessment`
(
    `assessment_id`          VARCHAR(64)  NOT NULL,
    `assessment_name`        VARCHAR(64)  NOT NULL,
    `template_id`            VARCHAR(64)  NOT NULL,
    `description`            VARCHAR(512) NULL,
    `assessment_status`      INT          NOT NULL DEFAULT 0,
    `assessment_creator`     VARCHAR(64)  NOT NULL,
    `to_user`                VARCHAR(64)  NOT NULL,
    `to_email`               VARCHAR(64)  NOT NULL,
    `to_user2`               VARCHAR(64)  NOT NULL,
    `to_email2`              VARCHAR(64)  NOT NULL,
    `assessment_create_date` DATETIME     NOT NULL,
    PRIMARY KEY (`assessment_id`)
) ENGINE = INNODB
  CHARACTER SET utf8
  COLLATE utf8_general_ci;

#问题
CREATE TABLE `question`
(
    `question_id`       VARCHAR(64)  NOT NULL,
    `id`                INT          NOT NULL,
    `template_id`       VARCHAR(64)  NULL,
    `assessment_id`     VARCHAR(64)  NULL,
    `create_time`       DATETIME     NOT NULL,
    `question_type`     VARCHAR(64)  NOT NULL,
    `question_title`    VARCHAR(128) NOT NULL,
    `description`       VARCHAR(128) NULL,
    `option_string`     VARCHAR(512) NOT NULL,
    `visible`           INT          NULL,
    `question_required` INT          NOT NULL,
    `row`               INT          NULL,
    `score`             INT          NULL,
    `type`              VARCHAR(64)  NULL,
    `answer_string`     VARCHAR(512) NULL,
    PRIMARY KEY (`question_id`)
) ENGINE = INNODB
  CHARACTER SET ucs2
  COLLATE ucs2_general_ci;

#逻辑
CREATE TABLE `logic`
(
    `logic_id`         VARCHAR(64)  NOT NULL,
    `id`               INT          NOT NULL,
    `logic_title`      VARCHAR(128) NOT NULL,
    `template_id`      VARCHAR(64)  NULL,
    `assessment_id`    VARCHAR(64)  NULL,
    `condition_string` VARCHAR(512) NOT NULL,
    `action_string`    VARCHAR(512) NOT NULL,
    `type`             VARCHAR(64)  NOT NULL,
    PRIMARY KEY (`logic_id`)
) ENGINE = INNODB
  CHARACTER SET ucs2
  COLLATE ucs2_general_ci;

#风险
CREATE TABLE `risk`
(
    `risk_id`       VARCHAR(64)  NOT NULL,
    `assessment_id` VARCHAR(64)  NOT NULL,
    `id`            INT          NOT NULL,
    `description`   VARCHAR(512) NULL,
    `score`         INT          NOT NULL DEFAULT 0,
    `risk_status`   INT          NOT NULL DEFAULT 0,
    `comment`       VARCHAR(512) NULL,
    PRIMARY KEY (`risk_id`)
) ENGINE = INNODB
  CHARACTER SET utf8
  COLLATE utf8_general_ci;

#风险库
CREATE TABLE `riskLibrary`
(
    `risk_library_id` VARCHAR(64)  NOT NULL,
    `module`          VARCHAR(64)  NULL,
    `name`            VARCHAR(64)  NULL,
    `description`     VARCHAR(512) NULL,
    `inherent_level`  INT          NOT NULL,
    `target_level`    INT          NOT NULL,
    `type`            VARCHAR(64)  NULL,
    `threaten`        INT          NOT NULL,
    `leak`            VARCHAR(64)  NULL,
    `plan`            VARCHAR(512) NULL,
    `status`          INT          NOT NULL,
    PRIMARY KEY (`risk_library_id`)
) ENGINE = INNODB
  CHARACTER SET utf8
  COLLATE utf8_general_ci;

#资产
CREATE TABLE `asset`
(
    `asset_id`       VARCHAR(64)  NOT NULL,
    `asset_name`     VARCHAR(64)  NOT NULL,
    `asset_type`     INT          NOT NULL,
    `asset_location` INT          NOT NULL,
    `asset_status`   INT          NOT NULL DEFAULT 1,
    `is_major_asset` INT          NOT NULL DEFAULT 1,
    `register_date`  DATE         NOT NULL,
    `expire_date`    DATE         NOT NULL,
    `comment`        VARCHAR(512) NULL,
    `data_type`      VARCHAR(64)  NULL,
    `data_field`     VARCHAR(64)  NULL,
    `data_quantity`  INT          NULL,
    `cross_border`   VARCHAR(64)  NULL,
    `to_third_party` VARCHAR(64)  NULL,
    PRIMARY KEY (`asset_id`)
) ENGINE = INNODB
  CHARACTER SET utf8
  COLLATE utf8_general_ci;

#控制
CREATE TABLE `control`
(
    `control_id`        VARCHAR(64)  NOT NULL,
    `control_name`      VARCHAR(64)  NOT NULL,
    `control_status`    INT          NOT NULL,
    `control_frame`     INT          NOT NULL,
    `control_type`      INT          NOT NULL,
    `control_direction` VARCHAR(512) NULL,
    `comment`           VARCHAR(512) NULL,
    PRIMARY KEY (`control_id`)
) ENGINE = INNODB
  CHARACTER SET utf8
  COLLATE utf8_general_ci;