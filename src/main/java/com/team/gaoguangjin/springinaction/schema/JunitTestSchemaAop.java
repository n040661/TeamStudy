package com.team.gaoguangjin.springinaction.schema;

import lombok.extern.slf4j.Slf4j;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * 基于schema的配置aop
 * 
 * 功能：如果对一个类进行前置增强或者环绕增强等，那么对里面的所有方法都会进行增强处理。
 * 
 * 如果不想这样，那就进行切点增强，或者切面增强。
 * @author Administrator
 * 
 */
@Slf4j
public class JunitTestSchemaAop {
	@Test
	public void test() {
		// 所有方法都会增加
		// testAopSpringXml();
		// 切面 pointcut="execution(* com..*.playLOL(..))"才会有增强
		// testAopSchemaXml();
		
		//
		testPiontXml();
		
	}
	
	private void testPiontXml() {
		try {
			ApplicationContext ac = new ClassPathXmlApplicationContext(
					"com/team/gaoguangjin/springinaction/schema/beans.xml");
			PlayGame play = (PlayGame) ac.getBean("target");
			
			// 后置增强
			play.playMiddle("nihao");
			
		}
		catch (Exception e) {
			log.error("测试xml aop增强失败！：" + e.getLocalizedMessage());
		}
	}
	
	/**
	 * 只有playLOL（）才会打印后置增强
	 */
	private void testAopSchemaXml() {
		try {
			ApplicationContext ac = new ClassPathXmlApplicationContext(
					"com/team/gaoguangjin/springinaction/schema/beans.xml");
			PlayGame play = (PlayGame) ac.getBean("target");
			play.playLOL("");
			play.playCs("");
			
		}
		catch (Exception e) {
			log.error("测试xml aop增强失败！：" + e.getLocalizedMessage());
		}
	}
	
	/**
	 * 打印： 信息: 【1】方法执行之前
	 * 
	 * 信息: 【2】玩车啊
	 * 
	 * 信息: 【1】方法执行之前
	 * 
	 * 信息: 【2】玩cs
	 * 
	 * 所有方法都会打印。
	 */
	private void testAopSpringXml() {
		try {
			ApplicationContext ac = new ClassPathXmlApplicationContext(
					"com/team/gaoguangjin/springinaction/schema/beans.xml");
			PlayGame play = (PlayGame) ac.getBean("play");
			play.playCar("");
			play.playCs("");
		}
		catch (Exception e) {
			log.error("测试xml aop增强失败！：" + e.getLocalizedMessage());
		}
		
	}
}
