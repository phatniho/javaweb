package classtest;

public class Tarena {
	String name;// 学生姓名
	int age;// 学生年龄
	String gender;// 学生性别
	static int count;// 集团学生数量统计
	static {// 集团招生广告
		System.out.println("父类静态代码块: \t达内招生广告:只要你想提升自己");
	}
	{// 网上找老师预约咨询
		System.out.println("父类构造代码块: \t" + this.name + "找老师咨询");
		count++;// 集团总学生数+1
	}

	public Tarena(String name, int age, String gender) {// 确定要学,但不确定学什么
		super();
		this.name = name;
		this.age = age;
		this.gender = gender;
		System.out.println("父类构造方法: \t" + this.name + "已确定学习");
	}
}
