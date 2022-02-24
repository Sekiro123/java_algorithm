package �������;

import java.lang.reflect.Proxy;

public class JdkProxyFactory {
    public static Object getProxy(Object target) {
        return Proxy.newProxyInstance(
                target.getClass().getClassLoader(), // Ŀ����������
                target.getClass().getInterfaces(),  // ������Ҫʵ�ֵĽӿڣ���ָ�����
                new DebugInvocationHandler(target)   // ��������Ӧ���Զ��� InvocationHandler
        );
    }

    public static void main(String[] args) {
        SmsService smsService = (SmsService) JdkProxyFactory.getProxy(new SmsServiceImpl());
        smsService.send("java");

    }
}

