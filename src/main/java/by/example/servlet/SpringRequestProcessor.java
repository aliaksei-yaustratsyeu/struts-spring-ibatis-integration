package by.example.servlet;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.RequestProcessor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.NoSuchBeanDefinitionException;
import org.springframework.util.Assert;
import org.springframework.util.ClassUtils;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Allows us get action from spring web application context. Overrides
 * <code>RequestProcessor.processActionCreate(request, response, mapping)</code> method.
 *
 * Created by a.evstratiev on 9/15/2014.
 */
public class SpringRequestProcessor extends RequestProcessor {

    private static final Logger logger = LoggerFactory.getLogger(SpringRequestProcessor.class);

    /**
     * <p>Return an <code>Action</code> instance that will be used to process
     * the current request, creating a new one if necessary.</p>
     * <p>We look for action in spring web application context. If we succeed we return action.
     * If not we call <code>RequestProcessor.processActionCreate</code> method.</p>
     *
     * @param request  The servlet request we are processing
     * @param response The servlet response we are creating
     * @param mapping  The mapping we are using
     * @return An <code>Action</code> instance that will be used to process the current request.
     * @throws IOException if an input/output error occurs
     */
    @Override
    protected Action processActionCreate(HttpServletRequest request,
                                         HttpServletResponse response, ActionMapping mapping) throws IOException {

        // Acquire the Action instance we will be using (if there is one)
        String className = mapping.getType();

        if (logger.isDebugEnabled()) {
            logger.debug(" Looking for Action instance for class " + className);
        }

        // try to get action instance from spring web application context
        Action instance = null;
        try {
            Class<?> clazz = ClassUtils.forName(className, ClassUtils.getDefaultClassLoader());
            Assert.isAssignable(Action.class, clazz);
            WebApplicationContext context = WebApplicationContextUtils.getWebApplicationContext(getServletContext());

            if (logger.isDebugEnabled()) {
                logger.debug("Looking for \"{}\" instance in spring app context", className);
            }

            instance = context.getBean((Class<Action>)clazz);

            if (instance.getServlet() == null) {
                instance.setServlet(this.servlet);
            }

            synchronized (actions) {
                actions.put(className, instance);
            }

        } catch (ClassNotFoundException ex) {
            logger.error("Could find class {}", className);
        } catch (NoSuchBeanDefinitionException ex) {
            logger.error("Could find class {} in spring web app context", className);
        }

        // if we couldn't get the instance from spring context then create it through the struts
        if (instance == null) {
            instance = super.processActionCreate(request, response, mapping);
        }

        return instance;
    }

}
