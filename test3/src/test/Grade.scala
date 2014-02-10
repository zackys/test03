package test

trait Grade {
  val name: String
  val rank: Int
  
  override def toString = name
  def >(g: Grade): Boolean
  def <(g: Grade): Boolean
  def >=(g: Grade): Boolean
  def <=(g: Grade): Boolean
}

object Grade {
  val フェロー: Grade = Grade("フェロー", 10)
  val 部門長: Grade = Grade("部門長", 10)
  val シニアエキスパート: Grade = Grade("シニアエキスパート", 10)
  val エキスパート: Grade = Grade("エキスパート", 20)
  val 主査: Grade = Grade("主査", 20)
  val 主任: Grade = Grade("主任", 30)
  val G2: Grade = Grade("G2", 40)
  val G1: Grade = Grade("G1", 50)
  
  def apply(n: String, r: Int): Grade = new GradeImpl(n, r)
}

private class GradeImpl(n: String, r: Int) extends Grade {
  val name = n
  val rank = r
  
  def >(g: Grade): Boolean = this.rank < g.rank
  def <(g: Grade): Boolean = this.rank > g.rank
  def >=(g: Grade): Boolean = this.rank <= g.rank
  def <=(g: Grade): Boolean = this.rank >= g.rank
}