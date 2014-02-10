package test.util

import java.util.Date
import java.text.SimpleDateFormat
import java.util.Calendar

trait 日付 extends Time {
}

object 日付 {
  val dateFormat = new SimpleDateFormat("yyyy/MM/dd")
  
  def apply(): 日付 = new 日付Impl(new Date())
  def apply(str: String): 日付 = new 日付Impl(str)
  def apply(mil: Long): 日付 = new 日付Impl(mil)
}

private class 日付Impl (d: Date) extends 日付{
  //ここで変数dateFormatを定義すると、コンストラクタで利用できないので、objectの方で定義する
  //private val dateFormat = new SimpleDateFormat("yyyy/MM/dd")
  
  val date = normalize(d)

  //補助コンストラクタ１
  def this(str: String) = {
    this(日付.dateFormat.parse(str))
  }
  
  //補助コンストラクタ２
  def this(mil: Long) = {
    this(new Date(mil))
  }
  
  private def normalize(d: Date): Date = {
    var cal: Calendar = Calendar.getInstance()
    cal.setTime(d)
    cal.set(Calendar.MILLISECOND, 0)
    cal.set(Calendar.SECOND, 0)
    cal.set(Calendar.MINUTE, 0)
    cal.set(Calendar.HOUR_OF_DAY, 0)
    
    cal.getTime()
  }
  
}

