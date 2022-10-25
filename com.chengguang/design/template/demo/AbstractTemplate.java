package design.template.demo;

/**
 * 子类可以替换掉父类的可变部分，但是子类却不可以改变模板方法锁代表的顶级逻辑
 */
public abstract class AbstractTemplate {
    /**
     * 模板方法
     */
    public void templateMethod() {
        abstractMethod();
        hookMethod();
        concreteMethod();
    }

    /**
     * 等待具体子类实现
     */
    protected abstract void abstractMethod();

    /**
     * 空方法 基本方法 也叫做默认钩子方法 相当于每个子类都有默认实现
     * 钩子方法应该以do开头
     */
    protected void hookMethod() {
    }

    /**
     * 基本方法 已经实现 顶级逻辑 子类不可改变
     */
    private final void concreteMethod() {
    }

}
