package com.xxxx.yeb.mapper;

import com.xxxx.yeb.pojo.Salary;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author zhoubin
 * @since 2020-07-17
 */
public interface SalaryMapper extends BaseMapper<Salary> {
    int countByName(String name);
}
