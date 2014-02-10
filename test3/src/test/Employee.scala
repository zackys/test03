package test

trait Employee {
  val id: String
  val name: String
  val dpt: 部門
  val grade: Grade
}

object Employee {
  def apply(id: String, name: String, dpt:部門, grade:Grade):Employee = {new EmployeeImpl(id, name, dpt, grade)}
}

private case class EmployeeImpl(id: String, name: String, dpt:部門, grade:Grade) extends Employee {
}