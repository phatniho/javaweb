package classtest;

public class Test {
	public static void main(String[] args) {
		System.out.println("----成都达内锦江中心正式开始招生------------------------");
		System.out.println("父类静态变量: \t当前集团总学生数量:" + Tarena.count);
		System.out.println("子类静态变量: \t当前Java班学生数量:" + Cgb1903.count);
		System.out.println("子类静态变量: \t当前Uid班学生数量:" + Uid1903.count);
		System.out.println("----招生详细过程------------------------------------");
		Cgb1903 s1 = new Cgb1903("彭海", 30, "男", "编程");
		System.out.println("----统计学生数量------------------------------------");
		System.out.println("父类静态变量: \t当前集团总学生数量:" + Tarena.count);
		System.out.println("子类静态变量: \t当前Java班学生数量:" + Cgb1903.count);
		System.out.println("----查看学生信息------------------------------------");
		System.out.println(s1.toString());
		System.out.println("----招生详细过程------------------------------------");
		Uid1903 s2 = new Uid1903("代兴荣", 18, "女", "设计");
		System.out.println("----统计学生数量------------------------------------");
		System.out.println("父类静态变量: \t当前集团总学生数量:" + Tarena.count);
		System.out.println("子类静态变量: \t当前Uid班学生数量:" + Uid1903.count);
		System.out.println("----查看学生信息------------------------------------");
		System.out.println(s2.toString());
	}
}
