package test.util

import java.util.Date
import java.text.SimpleDateFormat
import java.util.Calendar

trait 日付時刻 extends Time{
  def in(range: 時間帯): Boolean
  
  def get日付: 日付
  
  def get時刻: 時刻
}

object 日付時刻 {
  val dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm")
  
  def apply: 日付時刻 = new 日付時刻Impl(new Date())
  def apply(str: String): 日付時刻 = new 日付時刻Impl(str)
}

private class 日付時刻Impl (d: Date) extends 日付時刻{
  
  val date = normalize(d)

  //補助コンストラクタ１
  def this(str: String) = {
    this(日付時刻.dateFormat.parse(str))
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

    cal.getTime()
  }
  
  def get日付 = 日付(this.getTime)
  
  def get時刻 = 時刻(this.getTime - get日付.getTime)
    
  def in(range: 時間帯): Boolean = {
    range.contains(this.get時刻)
  }
  
}

