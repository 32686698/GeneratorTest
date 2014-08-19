package com.tian.mybatis;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.tian.mybatis.dao.SysUserMapper;
import com.tian.mybatis.model.SysUser;
import com.tian.mybatis.model.SysUserExample;

public class MyBatisTest {

	public static void main(String[] args) {
		SqlSession session = getSqlSessionFactory().openSession();
		SysUserExample example = new SysUserExample();
		example.createCriteria().andUsernameEqualTo("admin");
		SysUserMapper mapper = session.getMapper(SysUserMapper.class);
		List<SysUser> users = (List<SysUser>) mapper.selectByExample(example);
		System.out.println(users.get(0).getId());
	}
	
	/**
	 * 得到SqlSessionFactory 
	 * @return
	 */
	private static SqlSessionFactory getSqlSessionFactory (){
		String resource = "mybatis-config.xml";
		InputStream inputStream = null;
		try {
			inputStream = Resources.getResourceAsStream(resource);
		} catch (IOException e) {
			e.printStackTrace();
		}
		SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
		return sqlSessionFactory;
	}
}
