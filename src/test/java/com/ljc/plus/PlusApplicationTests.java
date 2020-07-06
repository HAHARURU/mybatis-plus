package com.ljc.plus;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.ljc.plus.entity.MineTest;
import com.ljc.plus.enums.GradeEnum;
import com.ljc.plus.mapper.MineTestMapper;
import com.ljc.plus.service.IMineTestService;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
class PlusApplicationTests {

    @Resource
    private MineTestMapper mineTestMapper;

    @Resource
    private IMineTestService mineTestService;

    @Test
    void mapperTest() {

        // 新增
        MineTest mineTest = new MineTest();
        mineTest.setName("111");
        mineTest.setValid(true);
        mineTest.setGrade(GradeEnum.MIDDLE);
        System.out.println(mineTestMapper.insert(mineTest));
        mineTest.setName("222");
        System.out.println(mineTestMapper.insert(mineTest));

        // 修改
        mineTest = new MineTest();
        mineTest.setName("cccc");
        QueryWrapper<MineTest> queryWrapper = new QueryWrapper<>();
        queryWrapper.gt("create_time", new Date(1577933728000L));
        System.out.println(mineTestMapper.update(mineTest, queryWrapper));

        // 查询
        queryWrapper = new QueryWrapper<>();
        IPage<MineTest> page = new Page<>(1, 1);
        IPage<MineTest> mineTestIPage = mineTestMapper.selectPage(page, queryWrapper);
        System.out.println(mineTestIPage.getRecords());

        // 删除
        queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("id", 1);
        System.out.println(mineTestMapper.delete(queryWrapper));
    }

    @Test
    public void serviceTest() {

        // 批量插入
        List<MineTest> mineTests = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            MineTest mineTest = new MineTest();
            mineTest.setName("qqq" + i);
            mineTest.setValid(true);
            mineTests.add(mineTest);
        }
        System.out.println(mineTestService.saveBatch(mineTests, 2));

        // 批量更新
        mineTests = new ArrayList<>();
        for (int i = 0; i < 2; i++) {
            MineTest mineTest = new MineTest();
            mineTest.setId(i + 3);
            mineTest.setName("rrr" + i);
            mineTests.add(mineTest);
        }
        System.out.println(mineTestService.updateBatchById(mineTests, 1));

        // 条件查询
        QueryWrapper<MineTest> queryWrapper = new QueryWrapper<>();
        queryWrapper.gt("create_time", new Date(1577933728000L));
        List<MineTest> list = mineTestService.list(queryWrapper);
        System.out.println(list);

        // 批量删除
        List<Integer> ids =  new ArrayList<>();
        ids.add(2);
        ids.add(3);
        System.out.println(mineTestService.removeByIds(ids));
    }

}
