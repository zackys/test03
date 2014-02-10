package test.util

import java.util.Date

trait Time {
  protected val date: Date
  
  def getTime: Long = date.getTime()
  
  override def toString = date.toString()
  
  def ＞(d:Time):Boolean = {
    return date.getTime > d.getTime
  }
  def ＜(d:Time):Boolean = {
    return date.getTime < d.getTime
  }
  def >(d:Time):Boolean = {
    return date.getTime > d.getTime
  }
  def <(d:Time):Boolean = {
    return date.getTime < d.getTime
  }
  
  def >=(d:Time):Boolean = {
    return date.getTime >= d.getTime
  }
  def <=(d:Time):Boolean = {
    //println("    " + date + "[" + date.getTime)
    //println("    " + d + "[" + d.getTime)
    //println("    " + (date.getTime <= d.getTime))
    return date.getTime <= d.getTime
  }
}