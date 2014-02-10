package test

trait 部門 {
  val code: String
  val name: String
}

object 部門 {
  val MF = 部門("1000","MF")
  val Finance = 部門("1010","Finance")
  val Audit = 部門("2010","Audit")
  val STC = 部門("1030","STC")
  
  def apply(identity: String, name: String): 部門 = {new 部門Impl(identity, name)}
}

private case class 部門Impl(code: String, name: String) extends 部門 {
}

/**
 * ケースクラスだと、new しないといけない。また、部門の場合は、部門毎の振る舞い定義が不要なため、クラスを分ける必要もない、と考える。
 * 逆に、振る舞いが異なる場合は、
 */
//case class MF extends Department
//case class Finantial extends Department