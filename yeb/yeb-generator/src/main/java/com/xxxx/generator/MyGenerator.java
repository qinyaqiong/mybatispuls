package com.xxxx.generator;

import com.baomidou.mybatisplus.annotation.DbType;
import com.baomidou.mybatisplus.generator.AutoGenerator;
import com.baomidou.mybatisplus.generator.config.DataSourceConfig;
import com.baomidou.mybatisplus.generator.config.GlobalConfig;
import com.baomidou.mybatisplus.generator.config.PackageConfig;
import com.baomidou.mybatisplus.generator.config.StrategyConfig;
import com.baomidou.mybatisplus.generator.config.converts.MySqlTypeConvert;
import com.baomidou.mybatisplus.generator.config.converts.SqlServerTypeConvert;
import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy;
public class MyGenerator {

    public static void main(String[] args) {
        // 代码生成器
        AutoGenerator autoGenerator = new AutoGenerator();
        // 全局配置
        GlobalConfig globalConfig = new GlobalConfig();
        //生成文件的输出目录
        String path="c:/mybatisplus";
        globalConfig.setOutputDir(path);
        // Author设置作者
        globalConfig.setAuthor("Qinyaqiong");
        // 文件覆盖
        globalConfig.setFileOverride(true);
        // 生成后打开文件
        globalConfig.setOpen(false);
        // 自定义文件名风格，%s自动填充表实体属性
        globalConfig.setMapperName("%sMapper");
        globalConfig.setXmlName("%sMapper");
        globalConfig.setServiceName("%sDao");
        globalConfig.setServiceImplName("%sDaoImpl");
        globalConfig.setEntityName("%s");
        globalConfig.setControllerName("%sController");
        autoGenerator.setGlobalConfig(globalConfig);

        // 数据源配置
        DataSourceConfig dataSourceConfig = new DataSourceConfig();
        dataSourceConfig.setDbType(DbType.MYSQL);
        dataSourceConfig.setTypeConvert(new SqlServerTypeConvert());
        dataSourceConfig.setUrl("jdbc:mysql://127.0.0.1:3306/egobao_lpg");
        dataSourceConfig.setDriverName("com.mysql.jdbc.Driver");
//        dataSourceConfig.setDriverName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        dataSourceConfig.setUsername("root");
        dataSourceConfig.setPassword("zhang12345");
        autoGenerator.setDataSource(dataSourceConfig);

        // 包名配置
        PackageConfig packageConfig = new PackageConfig();
        // 父包和子包名分开处理
        packageConfig.setParent("lpg.com");
        packageConfig.setController("web");
        packageConfig.setEntity("pojo");
        packageConfig.setMapper("mapper");
        packageConfig.setService("dao");
        packageConfig.setServiceImpl("dao.impl");
        autoGenerator.setPackageInfo(packageConfig);

        // 生成策略配置
        StrategyConfig strategy = new StrategyConfig();
        //设置命名格式
        strategy.setNaming(NamingStrategy.underline_to_camel);
        strategy.setColumnNaming(NamingStrategy.underline_to_camel);
        // 实体是否为lombok模型，默认 false
        strategy.setEntityLombokModel(true);
        //生成 @RestController 控制器
        strategy.setRestControllerStyle(true);
        // 驼峰转连字符
        strategy.setControllerMappingHyphenStyle(true);
        //表和前缀处理
//        strategy.setInclude("dt_defined_log".split(","));
        String[] tablePre = new String[]{"lpg_factory_fill"};
//        strategy.setInclude(tablePre);
////        strategy.setTablePrefix(tablePre);
////        strategy.setT
//        autoGenerator.setStrategy(strategy);
//        // 执行，以上相关参数可以基于动态输入获取
//
//        autoGenerator.execute();

        for (int i = 0; i < tablePre.length; i++) {
            strategy.setInclude(tablePre);

            autoGenerator.setStrategy(strategy);
            autoGenerator.execute();
        }
    }


}
