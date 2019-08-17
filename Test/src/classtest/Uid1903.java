package classtest;

public class Uid1903 extends Tarena {
	String like;// 学生兴趣
	static int count;// 班级学生数量统计
	static {// 班级宣传广告
		System.out.println("子类静态代码块: \tUid班宣传广告:只要你想通过学一门设计技术来提升自己");
	}
	{// 报名参加学习
		System.out.println("子类构造代码块: \t" + this.name + "报名交学费");
		count++;// 班级总学生数+1
	}

	public Uid1903(String name, int age, String gender, String like) {// 确定学的内容
		super(name, age, gender);// 集团所有学生都需要提交的信息
		this.like = like;// 特有兴趣方向
		System.out.println("子类构造方法: \t" + this.name + "成功加入Uid1903班");
	}

	@Override
	public String toString() {// 显示当前学生的信息
		return "Cgb1903 [name=" + name + ", age=" + age + ", gender=" + gender + ", school=" + like + "]";
	}
}
