package junit;

public class EmployeeDaoTest{
    // 测试前要运行的方法
	@MyBefore
	public void inti(){
		System.out.println("初始化");
	}
	// 测试方法
	@MyTest
	public void testSave(){
		System.out.println("保存");
	}
	// 测试方法
	@MyTest
	public void testDelete(){
		System.out.println("删除");
	}
	// 测试后要运行的方法
	@MyAfter
	public void destory(){
	    System.out.println("销毁");
	}
}

