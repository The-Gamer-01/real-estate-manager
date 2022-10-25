package com.hyx.generator;

import com.baomidou.mybatisplus.annotation.DbType;
import com.baomidou.mybatisplus.generator.AutoGenerator;
import com.baomidou.mybatisplus.generator.config.DataSourceConfig;
import com.baomidou.mybatisplus.generator.config.GlobalConfig;
import com.baomidou.mybatisplus.generator.config.PackageConfig;
import com.baomidou.mybatisplus.generator.config.StrategyConfig;
import com.baomidou.mybatisplus.generator.config.TemplateConfig;
import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy;

/**
 * MyBatis-Plus Generator.
 *
 * @author hyx
 **/

public class GeneratorServiceEntity {
    
    private static final String DB_URL = "jdbc:mysql://127.0.0.1:3306/real_estate_manager?useSSL=false&allowPublicKeyRetrieval=true&"
            + "useUnicode=true&characterEncoding=utf-8&serverTimezone=GMT%2B8";
    
    private static final String USERNAME = "root";
    
    private static final String PASSWORD = "huangyixuan";
    
    private static final String DRIVER_NAME = "com.mysql.jdbc.Driver";
    
    private static void generateByTables(String packageName, String[] tableNames) {
        final GlobalConfig config = new GlobalConfig();
        final DataSourceConfig dataSourceConfig = new DataSourceConfig();
        TemplateConfig templateConfig = new TemplateConfig();
        templateConfig.setXml(null);
        // 不生成controller
        templateConfig.setController("");
        // 不生成service
        templateConfig.setService("");
        templateConfig.setServiceImpl("");
        dataSourceConfig.setDbType(DbType.MYSQL)
                .setUrl(DB_URL)
                .setUsername(USERNAME)
                .setPassword(PASSWORD)
                .setDriverName(DRIVER_NAME);
        StrategyConfig strategyConfig = new StrategyConfig();
        strategyConfig.setCapitalMode(true)
                .setEntityLombokModel(true)
                .setNaming(NamingStrategy.underline_to_camel)
                .setInclude(tableNames);
        config.setActiveRecord(false)
                .setAuthor("hyx")
                .setOutputDir(".\\manager-common\\src\\main\\java")
                .setFileOverride(true);
        AutoGenerator autoGenerator = new AutoGenerator();
        autoGenerator.setGlobalConfig(config)
                .setDataSource(dataSourceConfig)
                .setStrategy(strategyConfig)
                .setPackageInfo(
                        new PackageConfig()
                        .setParent(packageName)
                ).setTemplate(templateConfig);
        autoGenerator.execute();
    }
    
    public static void main(String[] args) {
        String packageName = "com.hyx";
        String[] tableNames = new String[] {
                "house_info"
        };
        generateByTables(packageName, tableNames);
    }
}
