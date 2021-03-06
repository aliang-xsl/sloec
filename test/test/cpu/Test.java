package test.cpu;

import test.cpu.bean.MonitorInfoBean;
import test.cpu.service.IMonitorService;
import test.cpu.service.MonitorServiceImpl;

public class Test {

	public static void main(String[] args) throws Exception { 
		
		System.out.println(System.getProperty("os.name"));;//得到操作系统名字 
		System.out.println(System.getProperty("sun.os.patch.level"));;//得到操作系统版本
		
		System.out.println(Runtime.getRuntime().totalMemory() /1024);
		
        IMonitorService service = new MonitorServiceImpl();  
        MonitorInfoBean monitorInfo = service.getMonitorInfoBean();  
        
        System.out.println("cpu占有率=" + monitorInfo.getCpuRatio());  
          
        System.out.println("可使用内存=" + monitorInfo.getTotalMemory());  
        System.out.println("剩余内存=" + monitorInfo.getFreeMemory());  
        System.out.println("最大可使用内存=" + monitorInfo.getMaxMemory());  
          
        System.out.println("操作系统=" + monitorInfo.getOsName());  
        System.out.println("总的物理内存=" + monitorInfo.getTotalMemorySize() + "kb");  
        System.out.println("剩余的物理内存=" + monitorInfo.getFreeMemory() + "kb");  
        System.out.println("已使用的物理内存=" + monitorInfo.getUsedMemory() + "kb");  
        System.out.println("线程总数=" + monitorInfo.getTotalThread() + "kb");  
    }  
}
