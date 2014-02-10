package test.util

import java.util.Date
import java.text.SimpleDateFormat
import java.util.Calendar
import sun.security.jca.GetInstance

trait 時刻 extends Time {
  def in(range: 時間帯): Boolean
}

object 時刻 {
  val dateFormat: SimpleDateFormat = new SimpleDateFormat("HH:mm")
  val baseDate: Date = dateFormat.parse("00:00")
    
  def apply(): 時刻 = new 時刻Impl(0)
  def apply(str: String): 時刻 = new 時刻Impl(str)
  def apply(mil: Long): 時刻 = new 時刻Impl(mil)
}

private class 時刻Impl (d: Date) extends 時刻{
  
  val date = d

  //補助コンストラクタ１
  /**
   * 時刻フォーマットに従う文字列を指定する
   */
  def this(str: String) = {
    this(時刻.dateFormat.parse(str))
  }
  
  //補助コンストラクタ２
  /**
   * 基準日の00:00からの経過時間（ミリ秒）を指定する
   */
  def this(mil: Long) = {
    this(new Date(時刻.baseDate.getTime + mil))
  }
  
  def in(range: 時間帯): Boolean = {
    range.contains(this)
  }
  
}

