// Generated from D:/Programming/MiniExcel/src/sample\LibExp.g4 by ANTLR 4.8
package sample;
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link LibExpParser}.
 */
public interface LibExpListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by the {@code ToSetVar}
	 * labeled alternative in {@link LibExpParser#input}.
	 * @param ctx the parse tree
	 */
	void enterToSetVar(LibExpParser.ToSetVarContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ToSetVar}
	 * labeled alternative in {@link LibExpParser#input}.
	 * @param ctx the parse tree
	 */
	void exitToSetVar(LibExpParser.ToSetVarContext ctx);
	/**
	 * Enter a parse tree produced by the {@code Calculate}
	 * labeled alternative in {@link LibExpParser#input}.
	 * @param ctx the parse tree
	 */
	void enterCalculate(LibExpParser.CalculateContext ctx);
	/**
	 * Exit a parse tree produced by the {@code Calculate}
	 * labeled alternative in {@link LibExpParser#input}.
	 * @param ctx the parse tree
	 */
	void exitCalculate(LibExpParser.CalculateContext ctx);
	/**
	 * Enter a parse tree produced by the {@code SetVariable}
	 * labeled alternative in {@link LibExpParser#setVar}.
	 * @param ctx the parse tree
	 */
	void enterSetVariable(LibExpParser.SetVariableContext ctx);
	/**
	 * Exit a parse tree produced by the {@code SetVariable}
	 * labeled alternative in {@link LibExpParser#setVar}.
	 * @param ctx the parse tree
	 */
	void exitSetVariable(LibExpParser.SetVariableContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ToPlusOrMinus}
	 * labeled alternative in {@link LibExpParser#logicalOperation}.
	 * @param ctx the parse tree
	 */
	void enterToPlusOrMinus(LibExpParser.ToPlusOrMinusContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ToPlusOrMinus}
	 * labeled alternative in {@link LibExpParser#logicalOperation}.
	 * @param ctx the parse tree
	 */
	void exitToPlusOrMinus(LibExpParser.ToPlusOrMinusContext ctx);
	/**
	 * Enter a parse tree produced by the {@code Not}
	 * labeled alternative in {@link LibExpParser#logicalOperation}.
	 * @param ctx the parse tree
	 */
	void enterNot(LibExpParser.NotContext ctx);
	/**
	 * Exit a parse tree produced by the {@code Not}
	 * labeled alternative in {@link LibExpParser#logicalOperation}.
	 * @param ctx the parse tree
	 */
	void exitNot(LibExpParser.NotContext ctx);
	/**
	 * Enter a parse tree produced by the {@code Bigger}
	 * labeled alternative in {@link LibExpParser#logicalOperation}.
	 * @param ctx the parse tree
	 */
	void enterBigger(LibExpParser.BiggerContext ctx);
	/**
	 * Exit a parse tree produced by the {@code Bigger}
	 * labeled alternative in {@link LibExpParser#logicalOperation}.
	 * @param ctx the parse tree
	 */
	void exitBigger(LibExpParser.BiggerContext ctx);
	/**
	 * Enter a parse tree produced by the {@code BiggerEqual}
	 * labeled alternative in {@link LibExpParser#logicalOperation}.
	 * @param ctx the parse tree
	 */
	void enterBiggerEqual(LibExpParser.BiggerEqualContext ctx);
	/**
	 * Exit a parse tree produced by the {@code BiggerEqual}
	 * labeled alternative in {@link LibExpParser#logicalOperation}.
	 * @param ctx the parse tree
	 */
	void exitBiggerEqual(LibExpParser.BiggerEqualContext ctx);
	/**
	 * Enter a parse tree produced by the {@code NoteEqual}
	 * labeled alternative in {@link LibExpParser#logicalOperation}.
	 * @param ctx the parse tree
	 */
	void enterNoteEqual(LibExpParser.NoteEqualContext ctx);
	/**
	 * Exit a parse tree produced by the {@code NoteEqual}
	 * labeled alternative in {@link LibExpParser#logicalOperation}.
	 * @param ctx the parse tree
	 */
	void exitNoteEqual(LibExpParser.NoteEqualContext ctx);
	/**
	 * Enter a parse tree produced by the {@code LessEqual}
	 * labeled alternative in {@link LibExpParser#logicalOperation}.
	 * @param ctx the parse tree
	 */
	void enterLessEqual(LibExpParser.LessEqualContext ctx);
	/**
	 * Exit a parse tree produced by the {@code LessEqual}
	 * labeled alternative in {@link LibExpParser#logicalOperation}.
	 * @param ctx the parse tree
	 */
	void exitLessEqual(LibExpParser.LessEqualContext ctx);
	/**
	 * Enter a parse tree produced by the {@code Less}
	 * labeled alternative in {@link LibExpParser#logicalOperation}.
	 * @param ctx the parse tree
	 */
	void enterLess(LibExpParser.LessContext ctx);
	/**
	 * Exit a parse tree produced by the {@code Less}
	 * labeled alternative in {@link LibExpParser#logicalOperation}.
	 * @param ctx the parse tree
	 */
	void exitLess(LibExpParser.LessContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ToMultOrDiv}
	 * labeled alternative in {@link LibExpParser#plusOrMinus}.
	 * @param ctx the parse tree
	 */
	void enterToMultOrDiv(LibExpParser.ToMultOrDivContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ToMultOrDiv}
	 * labeled alternative in {@link LibExpParser#plusOrMinus}.
	 * @param ctx the parse tree
	 */
	void exitToMultOrDiv(LibExpParser.ToMultOrDivContext ctx);
	/**
	 * Enter a parse tree produced by the {@code Plus}
	 * labeled alternative in {@link LibExpParser#plusOrMinus}.
	 * @param ctx the parse tree
	 */
	void enterPlus(LibExpParser.PlusContext ctx);
	/**
	 * Exit a parse tree produced by the {@code Plus}
	 * labeled alternative in {@link LibExpParser#plusOrMinus}.
	 * @param ctx the parse tree
	 */
	void exitPlus(LibExpParser.PlusContext ctx);
	/**
	 * Enter a parse tree produced by the {@code Minus}
	 * labeled alternative in {@link LibExpParser#plusOrMinus}.
	 * @param ctx the parse tree
	 */
	void enterMinus(LibExpParser.MinusContext ctx);
	/**
	 * Exit a parse tree produced by the {@code Minus}
	 * labeled alternative in {@link LibExpParser#plusOrMinus}.
	 * @param ctx the parse tree
	 */
	void exitMinus(LibExpParser.MinusContext ctx);
	/**
	 * Enter a parse tree produced by the {@code Multiplication}
	 * labeled alternative in {@link LibExpParser#multOrDivOrMod}.
	 * @param ctx the parse tree
	 */
	void enterMultiplication(LibExpParser.MultiplicationContext ctx);
	/**
	 * Exit a parse tree produced by the {@code Multiplication}
	 * labeled alternative in {@link LibExpParser#multOrDivOrMod}.
	 * @param ctx the parse tree
	 */
	void exitMultiplication(LibExpParser.MultiplicationContext ctx);
	/**
	 * Enter a parse tree produced by the {@code Mod}
	 * labeled alternative in {@link LibExpParser#multOrDivOrMod}.
	 * @param ctx the parse tree
	 */
	void enterMod(LibExpParser.ModContext ctx);
	/**
	 * Exit a parse tree produced by the {@code Mod}
	 * labeled alternative in {@link LibExpParser#multOrDivOrMod}.
	 * @param ctx the parse tree
	 */
	void exitMod(LibExpParser.ModContext ctx);
	/**
	 * Enter a parse tree produced by the {@code DivInt}
	 * labeled alternative in {@link LibExpParser#multOrDivOrMod}.
	 * @param ctx the parse tree
	 */
	void enterDivInt(LibExpParser.DivIntContext ctx);
	/**
	 * Exit a parse tree produced by the {@code DivInt}
	 * labeled alternative in {@link LibExpParser#multOrDivOrMod}.
	 * @param ctx the parse tree
	 */
	void exitDivInt(LibExpParser.DivIntContext ctx);
	/**
	 * Enter a parse tree produced by the {@code Division}
	 * labeled alternative in {@link LibExpParser#multOrDivOrMod}.
	 * @param ctx the parse tree
	 */
	void enterDivision(LibExpParser.DivisionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code Division}
	 * labeled alternative in {@link LibExpParser#multOrDivOrMod}.
	 * @param ctx the parse tree
	 */
	void exitDivision(LibExpParser.DivisionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ToPow}
	 * labeled alternative in {@link LibExpParser#multOrDivOrMod}.
	 * @param ctx the parse tree
	 */
	void enterToPow(LibExpParser.ToPowContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ToPow}
	 * labeled alternative in {@link LibExpParser#multOrDivOrMod}.
	 * @param ctx the parse tree
	 */
	void exitToPow(LibExpParser.ToPowContext ctx);
	/**
	 * Enter a parse tree produced by the {@code Power}
	 * labeled alternative in {@link LibExpParser#pow}.
	 * @param ctx the parse tree
	 */
	void enterPower(LibExpParser.PowerContext ctx);
	/**
	 * Exit a parse tree produced by the {@code Power}
	 * labeled alternative in {@link LibExpParser#pow}.
	 * @param ctx the parse tree
	 */
	void exitPower(LibExpParser.PowerContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ChangeSign}
	 * labeled alternative in {@link LibExpParser#unaryMinus}.
	 * @param ctx the parse tree
	 */
	void enterChangeSign(LibExpParser.ChangeSignContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ChangeSign}
	 * labeled alternative in {@link LibExpParser#unaryMinus}.
	 * @param ctx the parse tree
	 */
	void exitChangeSign(LibExpParser.ChangeSignContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ToAtom}
	 * labeled alternative in {@link LibExpParser#unaryMinus}.
	 * @param ctx the parse tree
	 */
	void enterToAtom(LibExpParser.ToAtomContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ToAtom}
	 * labeled alternative in {@link LibExpParser#unaryMinus}.
	 * @param ctx the parse tree
	 */
	void exitToAtom(LibExpParser.ToAtomContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ConstantPI}
	 * labeled alternative in {@link LibExpParser#atom}.
	 * @param ctx the parse tree
	 */
	void enterConstantPI(LibExpParser.ConstantPIContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ConstantPI}
	 * labeled alternative in {@link LibExpParser#atom}.
	 * @param ctx the parse tree
	 */
	void exitConstantPI(LibExpParser.ConstantPIContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ConstantE}
	 * labeled alternative in {@link LibExpParser#atom}.
	 * @param ctx the parse tree
	 */
	void enterConstantE(LibExpParser.ConstantEContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ConstantE}
	 * labeled alternative in {@link LibExpParser#atom}.
	 * @param ctx the parse tree
	 */
	void exitConstantE(LibExpParser.ConstantEContext ctx);
	/**
	 * Enter a parse tree produced by the {@code Double}
	 * labeled alternative in {@link LibExpParser#atom}.
	 * @param ctx the parse tree
	 */
	void enterDouble(LibExpParser.DoubleContext ctx);
	/**
	 * Exit a parse tree produced by the {@code Double}
	 * labeled alternative in {@link LibExpParser#atom}.
	 * @param ctx the parse tree
	 */
	void exitDouble(LibExpParser.DoubleContext ctx);
	/**
	 * Enter a parse tree produced by the {@code Int}
	 * labeled alternative in {@link LibExpParser#atom}.
	 * @param ctx the parse tree
	 */
	void enterInt(LibExpParser.IntContext ctx);
	/**
	 * Exit a parse tree produced by the {@code Int}
	 * labeled alternative in {@link LibExpParser#atom}.
	 * @param ctx the parse tree
	 */
	void exitInt(LibExpParser.IntContext ctx);
	/**
	 * Enter a parse tree produced by the {@code Variable}
	 * labeled alternative in {@link LibExpParser#atom}.
	 * @param ctx the parse tree
	 */
	void enterVariable(LibExpParser.VariableContext ctx);
	/**
	 * Exit a parse tree produced by the {@code Variable}
	 * labeled alternative in {@link LibExpParser#atom}.
	 * @param ctx the parse tree
	 */
	void exitVariable(LibExpParser.VariableContext ctx);
	/**
	 * Enter a parse tree produced by the {@code Braces}
	 * labeled alternative in {@link LibExpParser#atom}.
	 * @param ctx the parse tree
	 */
	void enterBraces(LibExpParser.BracesContext ctx);
	/**
	 * Exit a parse tree produced by the {@code Braces}
	 * labeled alternative in {@link LibExpParser#atom}.
	 * @param ctx the parse tree
	 */
	void exitBraces(LibExpParser.BracesContext ctx);
}