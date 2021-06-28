package cn.edu.guet.mvc;

import java.lang.reflect.Method;

public class ControllerMapping {
    // 业务控制器类实例,  UserController, BookController ......
    private Class<?> controllerClass;

    // 业务控制器类实例的目标方法，即标注了@RequestMapping的方法实例
    private Method handleMethod;

    public ControllerMapping() {
    }

    public ControllerMapping(Class<?> controllerClass, Method handleMethod) {
        this.controllerClass = controllerClass;
        this.handleMethod = handleMethod;
    }

    public Class<?> getControllerClass() { return controllerClass; }

    public void setControllerClass(Class<?> controllerClass) {
        this.controllerClass = controllerClass;
    }

    public Method getHandleMethod() {
        return handleMethod;
    }

    public void setHandleMethod(Method handleMethod) {
        this.handleMethod = handleMethod;
    }

    @Override
    public String toString() {
        //UserController.login
        return "控制器类: " + controllerClass.getSimpleName() + "." + handleMethod.getName();
    }
}