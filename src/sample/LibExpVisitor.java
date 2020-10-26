// Generated from D:/Programming/MiniExcel/src/sample\LibExp.g4 by ANTLR 4.8
package sample;
import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link LibExpParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface LibExpVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by the {@code ToSetVar}
	 * labeled alternative in {@link LibExpParser#input}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitToSetVar(LibExpParser.ToSetVarContext ctx);
	/**
	 * Visit a parse tree produced by the {@code Calculate}
	 * labeled alternative in {@link LibExpParser#input}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCalculate(LibExpParser.CalculateContext ctx);
	/**
	 * Visit a parse tree produced by the {@code SetVariable}
	 * labeled alternative in {@link LibExpParser#setVar}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSetVariable(LibExpParser.SetVariableContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ToPlusOrMinus}
	 * labeled alternative in {@link LibExpParser#logicalOperation}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitToPlusOrMinus(LibExpParser.ToPlusOrMinusContext ctx);
	/**
	 * Visit a parse tree produced by the {@code Not}
	 * labeled alternative in {@link LibExpParser#logicalOperation}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNot(LibExpParser.NotContext ctx);
	/**
	 * Visit a parse tree produced by the {@code Bigger}
	 * labeled alternative in {@link LibExpParser#logicalOperation}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBigger(LibExpParser.BiggerContext ctx);
	/**
	 * Visit a parse tree produced by the {@code BiggerEqual}
	 * labeled alternative in {@link LibExpParser#logicalOperation}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBiggerEqual(LibExpParser.BiggerEqualContext ctx);
	/**
	 * Visit a parse tree produced by the {@code NoteEqual}
	 * labeled alternative in {@link LibExpParser#logicalOperation}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNoteEqual(LibExpParser.NoteEqualContext ctx);
	/**
	 * Visit a parse tree produced by the {@code LessEqual}
	 * labeled alternative in {@link LibExpParser#logicalOperation}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLessEqual(LibExpParser.LessEqualContext ctx);
	/**
	 * Visit a parse tree produced by the {@code Less}
	 * labeled alternative in {@link LibExpParser#logicalOperation}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLess(LibExpParser.LessContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ToMultOrDiv}
	 * labeled alternative in {@link LibExpParser#plusOrMinus}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitToMultOrDiv(LibExpParser.ToMultOrDivContext ctx);
	/**
	 * Visit a parse tree produced by the {@code Plus}
	 * labeled alternative in {@link LibExpParser#plusOrMinus}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPlus(LibExpParser.PlusContext ctx);
	/**
	 * Visit a parse tree produced by the {@code Minus}
	 * labeled alternative in {@link LibExpParser#plusOrMinus}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMinus(LibExpParser.MinusContext ctx);
	/**
	 * Visit a parse tree produced by the {@code Multiplication}
	 * labeled alternative in {@link LibExpParser#multOrDivOrMod}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMultiplication(LibExpParser.MultiplicationContext ctx);
	/**
	 * Visit a parse tree produced by the {@code Mod}
	 * labeled alternative in {@link LibExpParser#multOrDivOrMod}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMod(LibExpParser.ModContext ctx);
	/**
	 * Visit a parse tree produced by the {@code DivInt}
	 * labeled alternative in {@link LibExpParser#multOrDivOrMod}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDivInt(LibExpParser.DivIntContext ctx);
	/**
	 * Visit a parse tree produced by the {@code Division}
	 * labeled alternative in {@link LibExpParser#multOrDivOrMod}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDivision(LibExpParser.DivisionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ToPow}
	 * labeled alternative in {@link LibExpParser#multOrDivOrMod}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitToPow(LibExpParser.ToPowContext ctx);
	/**
	 * Visit a parse tree produced by the {@code Power}
	 * labeled alternative in {@link LibExpParser#pow}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPower(LibExpParser.PowerContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ChangeSign}
	 * labeled alternative in {@link LibExpParser#unaryMinus}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitChangeSign(LibExpParser.ChangeSignContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ToAtom}
	 * labeled alternative in {@link LibExpParser#unaryMinus}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitToAtom(LibExpParser.ToAtomContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ConstantPI}
	 * labeled alternative in {@link LibExpParser#atom}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitConstantPI(LibExpParser.ConstantPIContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ConstantE}
	 * labeled alternative in {@link LibExpParser#atom}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitConstantE(LibExpParser.ConstantEContext ctx);
	/**
	 * Visit a parse tree produced by the {@code Double}
	 * labeled alternative in {@link LibExpParser#atom}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDouble(LibExpParser.DoubleContext ctx);
	/**
	 * Visit a parse tree produced by the {@code Int}
	 * labeled alternative in {@link LibExpParser#atom}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitInt(LibExpParser.IntContext ctx);
	/**
	 * Visit a parse tree produced by the {@code Variable}
	 * labeled alternative in {@link LibExpParser#atom}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVariable(LibExpParser.VariableContext ctx);
	/**
	 * Visit a parse tree produced by the {@code Braces}
	 * labeled alternative in {@link LibExpParser#atom}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBraces(LibExpParser.BracesContext ctx);
}