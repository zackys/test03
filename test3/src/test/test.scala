package test

import util.日付
import util.時刻
import util.時間帯
import util.日付時刻
import 部門._
import Grade._


object test {
  //関数型（引数(Int, Int)と戻り値Int）の変数fに、関数リテラル（(n: Int, m:Int) => {n * m}）を代入
  val f: (Int, Int) => Int = (n: Int, m:Int) => {n * m}
  
  //メソッド定義
  def method(n: Int, m:Int): Int = {
    n * m
  }
  
  def main(args: Array[String]): Unit = {
    
    val g: (Employee, 日付時刻) => Boolean = (e:Employee, now:日付時刻) => (e, now) match {
      case (e, now) if (日付("2008/10/18") > now) && (e.dpt == MF) => true
      case (e, now) if (e.dpt == Finance) => false
      case (e, now) if (e.dpt == Audit) => false
      case (e, now) if (日付("2008/05/01") > now) && (now in 時間帯("11:00", "15:00")) && (e.grade > Grade.主査) => false
      case _ => true
    }
    
    val 入出許可判定: (日付時刻, Employee) => Boolean = (now:日付時刻, e:Employee) => 入出許可判定Impl(now, e.dpt, e.grade)
      
    val 入出許可判定Impl: (日付時刻, 部門, Grade) => Boolean = (now:日付時刻, dpt:部門, grade:Grade) => (now, dpt, grade) match {
      case (now, dpt, grade) if (日付("2008/10/18") > now) && (dpt == MF) => true
      case (now, dpt, grade) if (dpt == Finance) => false
      case (now, dpt, grade) if (dpt == Audit) => false
      case (now, dpt, grade) if (日付("2008/05/01") > now) && (now in 時間帯("11:00", "15:00")) && (grade >= Grade.主査) => true
      case _ => false
    }
    
    println(入出許可判定(日付時刻("2000/02/12 11:00"), Employee("123", "aaa", 部門.STC, Grade.主任)))
    
    println(入出許可判定(日付時刻("2000/02/12 11:00"), Employee("123", "aaa", 部門.MF, Grade.主任)))
    println(入出許可判定(日付時刻("2000/02/12 11:00"), Employee("123", "aaa", 部門.STC, Grade.主任)))
    println(入出許可判定(日付時刻("2000/02/12 11:00"), Employee("123", "aaa", 部門.STC, Grade.主査)))
    
    val h: (String, String, String) => (Int, String) = (x: String, y: String, z: String) => (x, y, z) match {
      case ("-", "Y", "Y") => (150, "Y")
      case ("-", "N", "Y") => (100, "Y")
      case ("Y", "Y", "N") => ( 70, "Y")
      case ("Y", "N", "N") => ( 50, "N")
      case _ => (200, "-")
    }
    
    val hh = h("Y","Y","N") 
    println(hh)
    println(hh._1)
    println(hh._2)
  }
}