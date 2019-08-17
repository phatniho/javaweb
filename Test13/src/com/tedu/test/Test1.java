package com.tedu.test;

import com.tedu.pojo.*;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.InputStream;
import java.util.*;

public class Test1 {
	private static SqlSessionFactory factory;
	private static SqlSession session;

	static {
		try {
			InputStream in = Resources.getResourceAsStream("sqlMapConfig.xml");
			factory = new SqlSessionFactoryBuilder().build(in);
			session = factory.openSession();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		while (true) {
			System.out.println("学生管理系统");
			System.out.println("1.查询所有");
			System.out.println("2.查询指定");
			System.out.println("3.新增信息");
			System.out.println("4.修改信息");
			System.out.println("5.删除信息");
			System.out.println("6.退出系统");
			System.out.print("输入要执行的操作:");
			String s = new Scanner(System.in).nextLine();
			if (s.equals("6")) {
				System.out.println("退出系统");
				break;
			} else {
				switch (s) {
				case "1":
					findAll();
					break;
				case "2":
					findBy();
					break;
				case "3":
					add();
					break;
				case "4":
					update();
					break;
				case "5":
					delete();
					break;
				default:
					System.out.println("没有这个选项,请重新输入");
					continue;
				}
			}
		}
	}

	private static void findAll() {
		while (true) {
			System.out.println("1.查询所有学生信息");
			System.out.println("2.查询所有教师信息");
			System.out.println("3.查询所有班级信息");
			System.out.println("4.查询所有课程信息");
			System.out.println("5.查询所有考试信息");
			System.out.println("6.返回上一层");
			System.out.print("输入要执行的操作:");
			String s = new Scanner(System.in).nextLine();
			if (s.equals("6")) {
				System.out.println("返回上一层");
				break;
			}
			switch (s) {
			case "1":
				List<Student> list1 = session.selectList("com.tedu.pojo.PojoMapper.findAllStudent");
				Iterator<Student> it1 = list1.iterator();
				while (it1.hasNext()) {
					Student c = it1.next();
					System.out.println(c);
				}
				break;
			case "2":
				List<Teacher> list2 = session.selectList("com.tedu.pojo.PojoMapper.findAllTeacher");
				Iterator<Teacher> it2 = list2.iterator();
				while (it2.hasNext()) {
					Teacher c = it2.next();
					System.out.println(c);
				}
				break;
			case "3":
				List<Classes> list3 = session.selectList("com.tedu.pojo.PojoMapper.findAllClasses");
				Iterator<Classes> it3 = list3.iterator();
				while (it3.hasNext()) {
					Classes c = it3.next();
					System.out.println(c);
				}
				break;
			case "4":
				List<Course> list4 = session.selectList("com.tedu.pojo.PojoMapper.findAllCourse");
				Iterator<Course> it4 = list4.iterator();
				while (it4.hasNext()) {
					Course c = it4.next();
					System.out.println(c);
				}
				break;
			case "5":
				List<Score> list5 = session.selectList("com.tedu.pojo.PojoMapper.findAllScore");
				Iterator<Score> it5 = list5.iterator();
				while (it5.hasNext()) {
					Score c = it5.next();
					System.out.println(c);
				}
				break;
			default:
				System.out.println("没有这个选项,请重新输入");
				continue;
			}
		}
	}

	private static void findBy() {
		while (true) {
			System.out.println("1.查询指定学生信息");
			System.out.println("2.查询指定教师信息");
			System.out.println("3.查询指定班级信息");
			System.out.println("4.查询指定课程信息");
			System.out.println("5.查询指定考试信息");
			System.out.println("6.返回上一层");
			System.out.print("输入要执行的操作:");
			String s = new Scanner(System.in).nextLine();
			if (s.equals("6")) {
				System.out.println("返回上一层");
				break;
			}
			switch (s) {
			case "1":
				findStuBy();
				break;
			case "2":
				findTeaBy();
				break;
			case "3":
				findClaBy();
				break;
			case "4":
				findCouBy();
				break;
			case "5":
				findScoBy();
				break;
			default:
				System.out.println("没有这个选项,请重新输入");
				break;
			}
		}
	}

	private static void findStuBy() {
		while (true) {
			System.out.println("1.按学号查询");
			System.out.println("2.按姓名查询");
			System.out.println("3.按性别查询");
			System.out.println("4.按班级查询");
			System.out.println("5.返回上一级");
			System.out.print("输入要执行的操作:");
			String s = new Scanner(System.in).nextLine();
			if (s.equals("5")) {
				System.out.println("返回上一层");
				break;
			}
			switch (s) {
			case "1":
				System.out.print("输入学号:");
				Integer sid = new Scanner(System.in).nextInt();
				List<Student> list1 = session.selectList("com.tedu.pojo.PojoMapper.findStuById", sid);
				Iterator<Student> it1 = list1.iterator();
				while (it1.hasNext()) {
					Student stu = it1.next();
					System.out.println(stu);
				}
				break;
			case "2":
				System.out.print("输入姓名:");
				String sname = new Scanner(System.in).nextLine();
				List<Student> list2 = session.selectList("com.tedu.pojo.PojoMapper.findStuByName", sname);
				Iterator<Student> it2 = list2.iterator();
				while (it2.hasNext()) {
					Student stu = it2.next();
					System.out.println(stu);
				}
				break;
			case "3":
				System.out.print("输入性别:");
				String gender = new Scanner(System.in).nextLine();
				List<Student> list3 = session.selectList("com.tedu.pojo.PojoMapper.findStuByGender", gender);
				Iterator<Student> it3 = list3.iterator();
				while (it3.hasNext()) {
					Student stu = it3.next();
					System.out.println(stu);
				}
				break;
			case "4":
				System.out.print("输入班级id:");
				Integer class_id = new Scanner(System.in).nextInt();
				List<Student> list4 = session.selectList("com.tedu.pojo.PojoMapper.findStuByClass", class_id);
				Iterator<Student> it4 = list4.iterator();
				while (it4.hasNext()) {
					Student stu = it4.next();
					System.out.println(stu);
				}
				break;
			default:
				System.out.println("没有这个选项,请重新输入");
				break;
			}
		}
	}

	private static void findTeaBy() {

		while (true) {
			System.out.println("1.按教师编号查询");
			System.out.println("2.按教师姓名查询");
			System.out.println("3.按教师性别查询");
			System.out.println("4.返回上一级");
			System.out.print("输入要执行的操作:");
			String s = new Scanner(System.in).nextLine();
			if (s.equals("4")) {
				System.out.println("返回上一层");
				break;
			}
			switch (s) {
			case "1":
				System.out.print("输入教师编号:");
				Integer tid = new Scanner(System.in).nextInt();
				List<Teacher> list1 = session.selectList("com.tedu.pojo.PojoMapper.findTeaById", tid);
				Iterator<Teacher> it1 = list1.iterator();
				while (it1.hasNext()) {
					Teacher stu = it1.next();
					System.out.println(stu);
				}
				break;
			case "2":
				System.out.print("输入教师姓名:");
				String sname = new Scanner(System.in).nextLine();
				List<Teacher> list2 = session.selectList("com.tedu.pojo.PojoMapper.findTeaByName", sname);
				Iterator<Teacher> it2 = list2.iterator();
				while (it2.hasNext()) {
					Teacher stu = it2.next();
					System.out.println(stu);
				}
				break;
			case "3":
				System.out.print("输入教师性别:");
				String tgender = new Scanner(System.in).nextLine();
				List<Teacher> list3 = session.selectList("com.tedu.pojo.PojoMapper.findTeaByGender", tgender);
				Iterator<Teacher> it3 = list3.iterator();
				while (it3.hasNext()) {
					Teacher stu = it3.next();
					System.out.println(stu);
				}
				break;
			default:
				System.out.println("没有这个选项,请重新输入");
				break;
			}
		}

	}

	private static void findClaBy() {

		while (true) {
			System.out.println("1.按班级编号查询");
			System.out.println("2.按班级名称查询");
			System.out.println("3.返回上一级");
			System.out.print("输入要执行的操作:");
			String s = new Scanner(System.in).nextLine();
			if (s.equals("3")) {
				System.out.println("返回上一层");
				break;
			}
			switch (s) {
			case "1":
				System.out.print("输入班级编号:");
				Integer cid = new Scanner(System.in).nextInt();
				List<Classes> list1 = session.selectList("com.tedu.pojo.PojoMapper.findClaById", cid);
				Iterator<Classes> it1 = list1.iterator();
				while (it1.hasNext()) {
					Classes stu = it1.next();
					System.out.println(stu);
				}
				break;
			case "2":
				System.out.print("输入班级名称:");
				String caption = new Scanner(System.in).nextLine();
				List<Classes> list2 = session.selectList("com.tedu.pojo.PojoMapper.findClaByName", caption);
				Iterator<Classes> it2 = list2.iterator();
				while (it2.hasNext()) {
					Classes stu = it2.next();
					System.out.println(stu);
				}
				break;
			default:
				System.out.println("没有这个选项,请重新输入");
				break;
			}
		}

	}

	private static void findCouBy() {

		while (true) {
			System.out.println("1.按课程编号查询");
			System.out.println("2.按课程名称查询");
			System.out.println("3.按任课老师查询编号");
			System.out.println("4.返回上一级");
			System.out.print("输入要执行的操作:");
			String s = new Scanner(System.in).nextLine();
			if (s.equals("4")) {
				System.out.println("返回上一层");
				break;
			}
			switch (s) {
			case "1":
				System.out.print("输入课程编号:");
				Integer cid = new Scanner(System.in).nextInt();
				List<Course> list1 = session.selectList("com.tedu.pojo.PojoMapper.findCouById", cid);
				Iterator<Course> it1 = list1.iterator();
				while (it1.hasNext()) {
					Course stu = it1.next();
					System.out.println(stu);
				}
				break;
			case "2":
				System.out.print("输入课程名称:");
				String cname = new Scanner(System.in).nextLine();
				List<Course> list2 = session.selectList("com.tedu.pojo.PojoMapper.findCouByName", cname);
				Iterator<Course> it2 = list2.iterator();
				while (it2.hasNext()) {
					Course stu = it2.next();
					System.out.println(stu);
				}
				break;
			case "3":
				System.out.print("输入任课老师编号:");
				Integer teach_id = new Scanner(System.in).nextInt();
				List<Course> list3 = session.selectList("com.tedu.pojo.PojoMapper.findCouByTeach_id", teach_id);
				Iterator<Course> it3 = list3.iterator();
				while (it3.hasNext()) {
					Course stu = it3.next();
					System.out.println(stu);
				}
				break;
			default:
				System.out.println("没有这个选项,请重新输入");
				break;
			}
		}

	}

	private static void findScoBy() {
		while (true) {
			System.out.println("1.按编号查询");
			System.out.println("2.按学号查询");
			System.out.println("3.按课程号查询");
			System.out.println("4.按分数查询");
			System.out.println("5.返回上一级");
			System.out.print("输入要执行的操作:");
			String s = new Scanner(System.in).nextLine();
			if (s.equals("5")) {
				System.out.println("返回上一层");
				break;
			}
			switch (s) {
			case "1":
				System.out.print("输入编号:");
				Integer sid = new Scanner(System.in).nextInt();
				List<Score> list1 = session.selectList("com.tedu.pojo.PojoMapper.findScoBySid", sid);
				Iterator<Score> it1 = list1.iterator();
				while (it1.hasNext()) {
					Score stu = it1.next();
					System.out.println(stu);
				}
				break;
			case "2":
				System.out.print("输入学号:");
				Integer stuid = new Scanner(System.in).nextInt();
				List<Score> list2 = session.selectList("com.tedu.pojo.PojoMapper.findScoByStuid", stuid);
				Iterator<Score> it2 = list2.iterator();
				while (it2.hasNext()) {
					Score stu = it2.next();
					System.out.println(stu);
				}
				break;
			case "3":
				System.out.print("输入课程号:");
				Integer couid = new Scanner(System.in).nextInt();
				List<Score> list3 = session.selectList("com.tedu.pojo.PojoMapper.findScoByCouid", couid);
				Iterator<Score> it3 = list3.iterator();
				while (it3.hasNext()) {
					Score stu = it3.next();
					System.out.println(stu);
				}
				break;
			case "4":
				System.out.print("输入低分数:");
				Integer number1 = new Scanner(System.in).nextInt();
				System.out.print("输入高分数:");
				Integer number2 = new Scanner(System.in).nextInt();
				Map<String, Integer> map = new HashMap<String, Integer>();
				map.put("number1", number1);
				map.put("number2", number2);
				List<Score> list4 = session.selectList("com.tedu.pojo.PojoMapper.findScoByNumber", map);
				Iterator<Score> it4 = list4.iterator();
				while (it4.hasNext()) {
					Score stu = it4.next();
					System.out.println(stu);
				}
				break;
			default:
				System.out.println("没有这个选项,请重新输入");
				break;
			}
		}
	}

	private static void add() {
		while (true) {
			System.out.println("1.新增学生信息");
			System.out.println("2.新增教师信息");
			System.out.println("3.新增班级信息");
			System.out.println("4.新增课程信息");
			System.out.println("5.新增考试信息");
			System.out.println("6.返回上一层");
			System.out.print("输入要执行的操作:");
			String s = new Scanner(System.in).nextLine();
			if (s.equals("6")) {
				System.out.println("返回上一层");
				break;
			}
			switch (s) {
			case "1":
				addStu();
				break;
			case "2":
				addTea();
				break;
			case "3":
				addCla();
				break;
			case "4":
				addCou();
				break;
			case "5":
				addSco();
				break;
			default:
				System.out.println("没有这个选项,请重新输入");
				continue;
			}
		}
	}

	private static void addStu() {
		outer: while (true) {
			System.out.print("输入学生姓名:");
			String name = new Scanner(System.in).nextLine();
			System.out.print("输入学生性别:");
			String gender = new Scanner(System.in).nextLine();
			System.out.print("输入学生班级编号:");
			Integer cid = new Scanner(System.in).nextInt();
			Student stu = new Student(null, name, gender, cid);
			int i = session.update("com.tedu.pojo.PojoMapper.addStu", stu);
			session.commit();
			System.out.println("成功添加了" + i + "名学生!");
			while (true) {
				System.out.println("要继续添加吗?y/n");
				String s = new Scanner(System.in).nextLine();
				if (s.equals("n")) {
					System.out.println("添加完成,返回上一级菜单!");
					break outer;
				} else if (s.equals("y")) {
					System.out.println("继续添加下一名学生");
					continue outer;
				} else {
					System.out.println("选项输入错误,请重新输入!");
					continue;
				}
			}
		}
	}

	private static void addTea() {
		outer: while (true) {
			System.out.print("输入教师姓名:");
			String name = new Scanner(System.in).nextLine();
			System.out.print("输入教师性别:");
			String gender = new Scanner(System.in).nextLine();
			Teacher t = new Teacher(null, name, gender);
			int i = session.update("com.tedu.pojo.PojoMapper.addTea", t);
			session.commit();
			System.out.println("成功添加了" + i + "名教师!");
			while (true) {
				System.out.println("要继续添加吗?y/n");
				String s = new Scanner(System.in).nextLine();
				if (s.equals("n")) {
					System.out.println("添加完成,返回上一级菜单!");
					break outer;
				} else if (s.equals("y")) {
					System.out.println("继续添加下一个");
					continue outer;
				} else {
					System.out.println("选项输入错误,请重新输入!");
					continue;
				}
			}
		}
	}

	private static void addCla() {
		outer: while (true) {
			System.out.print("输入班级名称:");
			String name = new Scanner(System.in).nextLine();
			Classes t = new Classes(null, name);
			int i = session.update("com.tedu.pojo.PojoMapper.addCla", t);
			session.commit();
			System.out.println("成功添加了" + i + "个班级!");
			while (true) {
				System.out.println("要继续添加吗?y/n");
				String s = new Scanner(System.in).nextLine();
				if (s.equals("n")) {
					System.out.println("添加完成,返回上一级菜单!");
					break outer;
				} else if (s.equals("y")) {
					System.out.println("继续添加下一个");
					continue outer;
				} else {
					System.out.println("选项输入错误,请重新输入!");
					continue;
				}
			}
		}
	}

	private static void addCou() {
		outer: while (true) {
			System.out.print("输入课程名称:");
			String name = new Scanner(System.in).nextLine();
			System.out.print("输入教师编号:");
			Integer tid = new Scanner(System.in).nextInt();
			Course t = new Course(null, name, tid);
			int i = session.update("com.tedu.pojo.PojoMapper.addCou", t);
			session.commit();
			System.out.println("成功添加了" + i + "门课程!");
			while (true) {
				System.out.println("要继续添加吗?y/n");
				String s = new Scanner(System.in).nextLine();
				if (s.equals("n")) {
					System.out.println("添加完成,返回上一级菜单!");
					break outer;
				} else if (s.equals("y")) {
					System.out.println("继续添加下一个");
					continue outer;
				} else {
					System.out.println("选项输入错误,请重新输入!");
					continue;
				}
			}
		}
	}

	private static void addSco() {
		outer: while (true) {
			System.out.print("输入学生编号:");
			Integer sid = new Scanner(System.in).nextInt();
			System.out.print("输入课程编号:");
			Integer cid = new Scanner(System.in).nextInt();
			System.out.print("输入分数:");
			Double number = new Scanner(System.in).nextDouble();
			Score t = new Score(null, sid, cid, number);
			int i = session.update("com.tedu.pojo.PojoMapper.addSco", t);
			session.commit();
			System.out.println("成功添加了" + i + "条成绩记录!");
			while (true) {
				System.out.println("要继续添加吗?y/n");
				String s = new Scanner(System.in).nextLine();
				if (s.equals("n")) {
					System.out.println("添加完成,返回上一级菜单!");
					break outer;
				} else if (s.equals("y")) {
					System.out.println("继续添加下一个");
					continue outer;
				} else {
					System.out.println("选项输入错误,请重新输入!");
					continue;
				}
			}
		}
	}

	private static void update() {
		while (true) {
			System.out.println("1.修改学生信息");
			System.out.println("2.修改教师信息");
			System.out.println("3.修改班级信息");
			System.out.println("4.修改课程信息");
			System.out.println("5.修改考试信息");
			System.out.println("6.返回上一层");
			System.out.print("输入要执行的操作:");
			String s = new Scanner(System.in).nextLine();
			if (s.equals("6")) {
				System.out.println("返回上一层");
				break;
			}
			switch (s) {
			case "1":
				updateStu();
				break;
			case "2":
				updateTea();
				break;
			case "3":
				updateCla();
				break;
			case "4":
				updateCou();
				break;
			case "5":
				updateSco();
				break;
			default:
				System.out.println("没有这个选项,请重新输入");
				continue;
			}
		}
	}

	private static void updateStu() {
		outer: while (true) {
			System.out.print("输入学生编号:");
			Integer sid = new Scanner(System.in).nextInt();
			System.out.print("输入学生姓名:");
			String name = new Scanner(System.in).nextLine();
			System.out.print("输入学生性别:");
			String gender = new Scanner(System.in).nextLine();
			System.out.print("输入学生班级编号:");
			Integer cid = new Scanner(System.in).nextInt();
			Student stu = new Student(sid, name, gender, cid);
			int i = session.update("com.tedu.pojo.PojoMapper.updateStu", stu);
			session.commit();
			System.out.println("成功修改了" + i + "名学生!");
			while (true) {
				System.out.println("要继续修改吗?y/n");
				String s = new Scanner(System.in).nextLine();
				if (s.equals("n")) {
					System.out.println("修改完成,返回上一级菜单!");
					break outer;
				} else if (s.equals("y")) {
					System.out.println("继续修改");
					continue outer;
				} else {
					System.out.println("选项输入错误,请重新输入!");
					continue;
				}
			}
		}
	}

	private static void updateTea() {
		outer: while (true) {
			System.out.print("输入教师编号:");
			Integer tid = new Scanner(System.in).nextInt();
			System.out.print("输入教师姓名:");
			String tname = new Scanner(System.in).nextLine();
			System.out.print("输入教师性别:");
			String tgender = new Scanner(System.in).nextLine();
			Teacher tea = new Teacher(tid, tname, tgender);
			int i = session.update("com.tedu.pojo.PojoMapper.updateTea", tea);
			session.commit();
			System.out.println("成功修改了" + i + "名教师!");
			while (true) {
				System.out.println("要继续修改吗?y/n");
				String s = new Scanner(System.in).nextLine();
				if (s.equals("n")) {
					System.out.println("修改完成,返回上一级菜单!");
					break outer;
				} else if (s.equals("y")) {
					System.out.println("继续修改");
					continue outer;
				} else {
					System.out.println("选项输入错误,请重新输入!");
					continue;
				}
			}
		}
	}

	private static void updateCla() {
		outer: while (true) {
			System.out.print("输入班级编号:");
			Integer cid = new Scanner(System.in).nextInt();
			System.out.print("输入班级名称:");
			String caption = new Scanner(System.in).nextLine();
			Classes cla = new Classes(cid, caption);
			int i = session.update("com.tedu.pojo.PojoMapper.updateCla", cla);
			session.commit();
			System.out.println("成功修改了" + i + "个班级!");
			while (true) {
				System.out.println("要继续修改吗?y/n");
				String s = new Scanner(System.in).nextLine();
				if (s.equals("n")) {
					System.out.println("修改完成,返回上一级菜单!");
					break outer;
				} else if (s.equals("y")) {
					System.out.println("继续修改");
					continue outer;
				} else {
					System.out.println("选项输入错误,请重新输入!");
					continue;
				}
			}
		}
	}

	private static void updateCou() {
		outer: while (true) {
			System.out.print("输入课程编号:");
			Integer cid = new Scanner(System.in).nextInt();
			System.out.print("输入课程名称:");
			String cname = new Scanner(System.in).nextLine();
			System.out.print("输入教师编号:");
			Integer tid = new Scanner(System.in).nextInt();
			Course cou = new Course(cid, cname, tid);
			int i = session.update("com.tedu.pojo.PojoMapper.updateCou", cou);
			session.commit();
			System.out.println("成功修改了" + i + "门课程!");
			while (true) {
				System.out.println("要继续修改吗?y/n");
				String s = new Scanner(System.in).nextLine();
				if (s.equals("n")) {
					System.out.println("修改完成,返回上一级菜单!");
					break outer;
				} else if (s.equals("y")) {
					System.out.println("继续修改");
					continue outer;
				} else {
					System.out.println("选项输入错误,请重新输入!");
					continue;
				}
			}
		}
	}

	private static void updateSco() {
		outer: while (true) {
			System.out.print("输入成绩编号:");
			Integer sid = new Scanner(System.in).nextInt();
			System.out.print("输入学生编号:");
			Integer stuid = new Scanner(System.in).nextInt();
			System.out.print("输入课程编号:");
			Integer couid = new Scanner(System.in).nextInt();
			System.out.print("输入考试成绩:");
			Double number = new Scanner(System.in).nextDouble();
			Score sco = new Score(sid, stuid, couid, number);
			int i = session.update("com.tedu.pojo.PojoMapper.updateSco", sco);
			session.commit();
			System.out.println("成功修改了" + i + "条记录!");
			while (true) {
				System.out.println("要继续修改吗?y/n");
				String s = new Scanner(System.in).nextLine();
				if (s.equals("n")) {
					System.out.println("修改完成,返回上一级菜单!");
					break outer;
				} else if (s.equals("y")) {
					System.out.println("继续修改");
					continue outer;
				} else {
					System.out.println("选项输入错误,请重新输入!");
					continue;
				}
			}
		}
	}

	private static void delete() {
		while (true) {
			System.out.println("1.删除学生信息");
			System.out.println("2.删除教师信息");
			System.out.println("3.删除班级信息");
			System.out.println("4.删除课程信息");
			System.out.println("5.删除考试信息");
			System.out.println("6.返回上一层");
			System.out.print("输入要执行的操作:");
			String s = new Scanner(System.in).nextLine();
			if (s.equals("6")) {
				System.out.println("返回上一层");
				break;
			}
			switch (s) {
			case "1":
				deleteStu();
				break;
			case "2":
				deleteTea();
				break;
			case "3":
				deleteCla();
				break;
			case "4":
				deleteCou();
				break;
			case "5":
				deleteSco();
				break;
			default:
				System.out.println("没有这个选项,请重新输入");
				continue;
			}
		}
	}

	private static void deleteStu() {
		outer: while (true) {
			System.out.println("1.按学号删除");
			System.out.println("2.按姓名删除");
			System.out.println("3.按性别删除");
			System.out.println("4.按班级删除");
			System.out.println("5.返回上一级");
			System.out.print("选择删除方式:");
			String s = new Scanner(System.in).nextLine();
			if (s.equals("5")) {
				System.out.println("返回上一级");
				break;
			}
			String s1 = null;
			String s2 = null;
			Integer i1 = null;
			switch (s) {
			case "1":
				s1 = "sid";
				System.out.print("输入要删除的学生编号:");
				i1 = new Scanner(System.in).nextInt();
				deleteStuBy(s1, i1);
				break;
			case "2":
				s1 = "sname";
				System.out.print("输入要删除的学生姓名:");
				s2 = new Scanner(System.in).nextLine();
				deleteStuBy(s1, s2);
				break;
			case "3":
				s1 = "gender";
				System.out.print("输入要删除的学生性别:");
				s2 = new Scanner(System.in).nextLine();
				deleteStuBy(s1, s2);
				break;
			case "4":
				s1 = "class_id";
				System.out.print("输入要删除的学生的班级编号:");
				i1 = new Scanner(System.in).nextInt();
				deleteStuBy(s1, i1);
				break;
			default:
				System.out.println("输入有误,请重新输入");
				continue;
			}
			while (true) {
				System.out.println("要继续删除吗?y/n");
				String l = new Scanner(System.in).nextLine();
				if (l.equals("n")) {
					System.out.println("修改完成,返回上一级菜单!");
					break outer;
				} else if (l.equals("y")) {
					System.out.println("继续修改");
					continue outer;
				} else {
					System.out.println("选项输入错误,请重新输入!");
					continue;
				}
			}
		}
	}

	private static void deleteStuBy(String s1, Integer i1) {
		Map map = new HashMap();
		map.put("name1", s1);
		map.put("name2", i1);
		int i = session.update("com.tedu.pojo.PojoMapper.deleteStuBy", map);
		session.commit();
		System.out.println("成功删除了" + i + "条记录!");
	}

	private static void deleteStuBy(String s1, String s2) {
		Map map = new HashMap();
		map.put("name1", s1);
		map.put("name2", s2);
		int i = session.update("com.tedu.pojo.PojoMapper.deleteStuBy", map);
		session.commit();
		System.out.println("成功删除了" + i + "条记录!");
	}

	private static void deleteTea() {
		outer: while (true) {
			System.out.println("1.按教师编号删除");
			System.out.println("2.按教师姓名删除");
			System.out.println("3.按教师性别删除");
			System.out.println("4.返回上一级");
			System.out.print("选择删除方式:");
			String s = new Scanner(System.in).nextLine();
			if (s.equals("4")) {
				System.out.println("返回上一级");
				break;
			}
			String s1 = null;
			String s2 = null;
			Integer i1 = null;
			switch (s) {
			case "1":
				s1 = "tid";
				System.out.print("输入要删除的教师编号:");
				i1 = new Scanner(System.in).nextInt();
				deleteTeaBy(s1, i1);
				break;
			case "2":
				s1 = "tname";
				System.out.print("输入要删除的教师姓名:");
				s2 = new Scanner(System.in).nextLine();
				deleteTeaBy(s1, s2);
				break;
			case "3":
				s1 = "tgender";
				System.out.print("输入要删除的教师性别:");
				s2 = new Scanner(System.in).nextLine();
				deleteTeaBy(s1, s2);
				break;
			default:
				System.out.println("输入有误,请重新输入");
				continue;
			}
			while (true) {
				System.out.println("要继续删除吗?y/n");
				String l = new Scanner(System.in).nextLine();
				if (l.equals("n")) {
					System.out.println("修改完成,返回上一级菜单!");
					break outer;
				} else if (l.equals("y")) {
					System.out.println("继续修改");
					continue outer;
				} else {
					System.out.println("选项输入错误,请重新输入!");
					continue;
				}
			}
		}
	}

	private static void deleteTeaBy(String s1, String s2) {
		Map map = new HashMap();
		map.put("name1", s1);
		map.put("name2", s2);
		int i = session.update("com.tedu.pojo.PojoMapper.deleteTeaBy", map);
		session.commit();
		System.out.println("成功删除了" + i + "条记录!");
	}

	private static void deleteTeaBy(String s1, Integer i1) {
		Map map = new HashMap();
		map.put("name1", s1);
		map.put("name2", i1);
		int i = session.update("com.tedu.pojo.PojoMapper.deleteTeaBy", map);
		session.commit();
		System.out.println("成功删除了" + i + "条记录!");
	}

	private static void deleteCla() {
		outer: while (true) {
			System.out.println("1.按班级编号删除");
			System.out.println("2.按班级名称删除");
			System.out.println("3.返回上一级");
			System.out.print("选择删除方式:");
			String s = new Scanner(System.in).nextLine();
			if (s.equals("3")) {
				System.out.println("返回上一级");
				break;
			}
			String s1 = null;
			String s2 = null;
			Integer i1 = null;
			switch (s) {
			case "1":
				s1 = "cid";
				System.out.print("输入要删除的班级编号:");
				i1 = new Scanner(System.in).nextInt();
				deleteClaBy(s1, i1);
				break;
			case "2":
				s1 = "caption";
				System.out.print("输入要删除的班级名称:");
				s2 = new Scanner(System.in).nextLine();
				deleteClaBy(s1, s2);
				break;
			default:
				System.out.println("输入有误,请重新输入");
				continue;
			}
			while (true) {
				System.out.println("要继续删除吗?y/n");
				String l = new Scanner(System.in).nextLine();
				if (l.equals("n")) {
					System.out.println("修改完成,返回上一级菜单!");
					break outer;
				} else if (l.equals("y")) {
					System.out.println("继续修改");
					continue outer;
				} else {
					System.out.println("选项输入错误,请重新输入!");
					continue;
				}
			}
		}
	}

	private static void deleteClaBy(String s1, String s2) {
		Map map = new HashMap();
		map.put("name1", s1);
		map.put("name2", s2);
		int i = session.update("com.tedu.pojo.PojoMapper.deleteClaBy", map);
		session.commit();
		System.out.println("成功删除了" + i + "条记录!");
	}

	private static void deleteClaBy(String s1, Integer i1) {
		Map map = new HashMap();
		map.put("name1", s1);
		map.put("name2", i1);
		int i = session.update("com.tedu.pojo.PojoMapper.deleteClaBy", map);
		session.commit();
		System.out.println("成功删除了" + i + "条记录!");
	}

	private static void deleteCou() {
		outer: while (true) {
			System.out.println("1.按课程编号删除");
			System.out.println("2.按课程名称删除");
			System.out.println("3.按任课老师编号删除");
			System.out.println("4.返回上一级");
			System.out.print("选择删除方式:");
			String s = new Scanner(System.in).nextLine();
			if (s.equals("4")) {
				System.out.println("返回上一级");
				break;
			}
			String s1 = null;
			String s2 = null;
			Integer i1 = null;
			switch (s) {
			case "1":
				s1 = "sid";
				System.out.print("输入要删除的课程编号:");
				i1 = new Scanner(System.in).nextInt();
				deleteCouBy(s1, i1);
				break;
			case "2":
				s1 = "student_id";
				System.out.print("输入要删除的课程名称:");
				s2 = new Scanner(System.in).nextLine();
				deleteCouBy(s1, s2);
				break;
			case "3":
				s1 = "corse_id";
				System.out.print("输入要删除的任课老师编号:");
				i1 = new Scanner(System.in).nextInt();
				deleteCouBy(s1, i1);
				break;
			default:
				System.out.println("输入有误,请重新输入");
				continue;
			}
			while (true) {
				System.out.println("要继续删除吗?y/n");
				String l = new Scanner(System.in).nextLine();
				if (l.equals("n")) {
					System.out.println("修改完成,返回上一级菜单!");
					break outer;
				} else if (l.equals("y")) {
					System.out.println("继续修改");
					continue outer;
				} else {
					System.out.println("选项输入错误,请重新输入!");
					continue;
				}
			}
		}
	}

	private static void deleteCouBy(String s1, String s2) {
		Map map = new HashMap();
		map.put("name1", s1);
		map.put("name2", s2);
		int i = session.update("com.tedu.pojo.PojoMapper.deleteCouBy", map);
		session.commit();
		System.out.println("成功删除了" + i + "条记录!");
	}

	private static void deleteCouBy(String s1, Integer i1) {
		Map map = new HashMap();
		map.put("name1", s1);
		map.put("name2", i1);
		int i = session.update("com.tedu.pojo.PojoMapper.deleteCouBy", map);
		session.commit();
		System.out.println("成功删除了" + i + "条记录!");
	}

	private static void deleteSco() {
		outer: while (true) {
			System.out.println("1.按编号删除");
			System.out.println("2.按学生编号删除");
			System.out.println("3.按课程编号删除");
			System.out.println("4.按成绩删除");
			System.out.println("5.返回上一级");
			System.out.print("选择删除方式:");
			String s = new Scanner(System.in).nextLine();
			if (s.equals("5")) {
				System.out.println("返回上一级");
				break;
			}
			String s1 = null;
			Integer i1 = null;
			Double d1 = null;
			switch (s) {
			case "1":
				s1 = "sid";
				System.out.print("输入要删除的记录编号:");
				i1 = new Scanner(System.in).nextInt();
				deleteScoBy(s1, i1);
				break;
			case "2":
				s1 = "student_id";
				System.out.print("输入要删除的学生编号:");
				i1 = new Scanner(System.in).nextInt();
				deleteScoBy(s1, i1);
				break;
			case "3":
				s1 = "corse_id";
				System.out.print("输入要删除的课程编号:");
				i1 = new Scanner(System.in).nextInt();
				deleteScoBy(s1, i1);
				break;
			case "4":
				s1 = "number";
				System.out.print("输入要删除的成绩:");
				d1 = new Scanner(System.in).nextDouble();
				deleteScoBy(s1, d1);
				break;
			default:
				System.out.println("输入有误,请重新输入");
				continue;
			}
			while (true) {
				System.out.println("要继续删除吗?y/n");
				String l = new Scanner(System.in).nextLine();
				if (l.equals("n")) {
					System.out.println("修改完成,返回上一级菜单!");
					break outer;
				} else if (l.equals("y")) {
					System.out.println("继续修改");
					continue outer;
				} else {
					System.out.println("选项输入错误,请重新输入!");
					continue;
				}
			}
		}
	}

	private static void deleteScoBy(String s1, Integer i1) {
		Map map = new HashMap();
		map.put("name1", s1);
		map.put("name2", i1);
		int i = session.update("com.tedu.pojo.PojoMapper.deleteScoBy", map);
		session.commit();
		System.out.println("成功删除了" + i + "条记录!");
	}

	private static void deleteScoBy(String s1, Double d1) {
		Map map = new HashMap();
		map.put("name1", s1);
		map.put("name2", d1);
		int i = session.update("com.tedu.pojo.PojoMapper.deleteScoBy", map);
		session.commit();
		System.out.println("成功删除了" + i + "条记录!");
	}
}
