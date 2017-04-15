package com.mvpjava.junit5.extensions;

import java.lang.reflect.Method;
import java.util.Set;
import java.util.logging.Logger;

import org.junit.jupiter.api.extension.AfterTestExecutionCallback;
import org.junit.jupiter.api.extension.BeforeTestExecutionCallback;
import org.junit.jupiter.api.extension.ExtensionContext.Namespace;
import org.junit.jupiter.api.extension.ExtensionContext.Store;
import org.junit.jupiter.api.extension.TestExtensionContext;
import org.junit.platform.commons.util.ReflectionUtils;

public class TimingExtension implements BeforeTestExecutionCallback, AfterTestExecutionCallback {

   private static final Logger LOG = Logger.getLogger(TimingExtension.class.getName());

    @Override
    public void beforeTestExecution(TestExtensionContext context) throws Exception {
        getStore(context).put(context.getTestMethod().get(), System.currentTimeMillis());
    }

    @Override
    public void afterTestExecution(TestExtensionContext context) throws Exception {
        final long MAX_DURATION_ALLOWED = 1000; //ms

        Method testMethod = context.getTestMethod().get();
        long start = getStore(context).remove(testMethod, long.class);
        long duration = System.currentTimeMillis() - start;
        
//        Set<String> tags = context.getTags();
//        if (tags.contains("Performance") && duration > MAX_DURATION_ALLOWED) {
//            LOG.info(() -> String.format("Method [%s] took %s ms (too long! time to fine tune) .", testMethod.getName(), duration));
//        }
    }

    private Store getStore(TestExtensionContext context) {
        return context.getStore(Namespace.create(getClass(), context));
    }

}
