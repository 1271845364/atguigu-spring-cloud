package com.yejinhui.condition;

import org.springframework.context.annotation.ImportSelector;
import org.springframework.core.type.AnnotationMetadata;

/**
 * 自定义逻辑返回需要导入的组件
 * 
 * @author ye.jinhui
 * @date 2018年8月18日
 */
public class MyImportSelector implements ImportSelector {

	/**
	 * @param importingClassMetadata 当前标注@Import注解的类的所有注解信息
	 * @return 返回要导入到容器中的组件全类名
	 */
	public String[] selectImports(AnnotationMetadata importingClassMetadata) {
//		importingClassMetadata.get
		
		return new String[]{"com.yejinhui.bean.Blue","com.yejinhui.bean.Yellow"};
	}

}
