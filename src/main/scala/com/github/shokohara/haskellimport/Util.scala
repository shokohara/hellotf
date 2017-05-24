package com.github.shokohara.haskellimport

object Util {
  /**
    * @see https://www.stackage.org/haddock/lts-8.15/ghc-8.0.2/src/Util.html#liftFst
    */
  def liftFst[A, B, C](f: A => B)(a: (A, C)): (B, C) = (f(a._1), a._2)

  /**
    * @see https://www.stackage.org/haddock/lts-8.15/ghc-8.0.2/src/Util.html#liftSnd
    */
  def liftSnd[A, B, C](f: A => B)(a: (C, A)): (C, B) = (a._1, f(a._2))

  object implicits {
    implicit class RichTuple2[A, B](t: (A, B)) {
      def liftFst[C](f: A => C): (C, B) = Util.liftFst(f)(t)
      def liftSnd[C](f: B => C): (A, C) = Util.liftSnd(f)(t)
    }
  }
}
