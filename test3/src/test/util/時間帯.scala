package test.util

import java.util.Date
import java.text.SimpleDateFormat
import java.util.Calendar

trait 時間帯 {
  def contains(t:時刻): Boolean
}

object 時間帯 {  
  def apply(strFrom: String, strTo: String): 時間帯 = new 時間帯Impl(strFrom, strTo)
}

private class 時間帯Impl (_from: 時刻, _to:時刻) extends 時間帯{
  
  val from:時刻 = _from
  val to:時刻 = _to
  
  def this(strFrom: String, strTo: String) = {
    this(時刻(strFrom), 時刻(strTo))
  }
  
  override def toString = from + " ～ " + to
  
  def contains(t:時刻): Boolean = {
    //println("  1/" + (from <= t))
    //println("  2/" + (t <= to))
    //println("  3/" + (from <= t && t <= to))
    from <= t && t <= to
  }
}

