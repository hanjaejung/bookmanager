package com.example.bookmanager.support;
import com.example.bookmanager.support.BeenUtils;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

//entity리스너에 스프링been을 주입하기 위한 클래스
//UserEntityListener클래스에 UserHistoryRepository를 주입하기 위해 만든 클래스
@Component
public class BeenUtils implements ApplicationContextAware {
    private static ApplicationContext applicationContext;

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        BeenUtils.applicationContext = applicationContext;
    }

    public static <T> T getBean(Class<T> clazz) {
        return applicationContext.getBean(clazz);
    }
}
