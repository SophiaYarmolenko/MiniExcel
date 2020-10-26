package sample;

public class LibExpBaseVisitorImpl extends LibExpBaseVisitor<Double>
{
        @Override
        public Double visitPlus(LibExpParser.PlusContext ctx)
        {
            return visit(ctx.plusOrMinus()) + visit(ctx.multOrDivOrMod());
        }

        @Override
        public Double visitMinus(LibExpParser.MinusContext ctx)
        {
            return visit(ctx.plusOrMinus()) - visit(ctx.multOrDivOrMod());
        }

        @Override
        public Double visitMultiplication(LibExpParser.MultiplicationContext ctx)
        {
            return visit(ctx.multOrDivOrMod()) * visit(ctx.pow());
        }

        @Override
        public Double visitDivision(LibExpParser.DivisionContext ctx)
        {
            return visit(ctx.multOrDivOrMod()) / visit(ctx.pow());
        }

        @Override
        public Double visitMod(LibExpParser.ModContext ctx)
        {
            return visit(ctx.multOrDivOrMod()) % visit(ctx.pow());
        }
        @Override
        public Double visitDivInt(LibExpParser.DivIntContext ctx)
        {
            double left = visit(ctx.multOrDivOrMod());
            double right = visit(ctx.pow());
            if((double)(left/right - (int)(left / right)) >= 0.5)
            {
                return (double)((int)(left / right));
            } else
                return (double)((int)(left / right)) - 1;
        }

        @Override
        public Double visitLess(LibExpParser.LessContext ctx)
        {
            if( visit(ctx.logicalOperation()) < visit(ctx.plusOrMinus()))
                return 1.0;
            else
                return 0.0;
        }

        @Override
        public Double visitBigger(LibExpParser.BiggerContext ctx)
        {
            if( visit(ctx.logicalOperation()) > visit(ctx.plusOrMinus()))
                return 1.0;
            else
                return 0.0;
        }

        @Override
        public Double visitLessEqual(LibExpParser.LessEqualContext ctx)
        {
            if( visit(ctx.logicalOperation()) <= visit(ctx.plusOrMinus()))
                return 1.0;
            else
                return 0.0;
        }

        @Override
        public Double visitBiggerEqual(LibExpParser.BiggerEqualContext ctx)
        {
            if( visit(ctx.logicalOperation()) >= visit(ctx.plusOrMinus()))
                return 1.0;
            else
                return 0.0;
        }

        @Override
        public Double visitNot(LibExpParser.NotContext ctx)
        {
            if( visit(ctx.plusOrMinus()) == 0)
                return 1.0;
            else
                return 0.0;
        }
        @Override
        public Double visitNoteEqual(LibExpParser.NoteEqualContext ctx)
        {
            if( !visit(ctx.logicalOperation()).equals(visit(ctx.plusOrMinus())))
                return 1.0;
            else
                return 0.0;
        }


        @Override
        public Double visitPower(LibExpParser.PowerContext ctx)
        {
            if (ctx.pow() != null)
                return Math.pow(visit(ctx.unaryMinus()), visit(ctx.pow()));
            return visit(ctx.unaryMinus());
        }

        @Override
        public Double visitChangeSign(LibExpParser.ChangeSignContext ctx)
        {
            return -1*visit(ctx.unaryMinus());
        }

        @Override
        public Double visitBraces(LibExpParser.BracesContext ctx)
        {
            return visit(ctx.logicalOperation());
        }

        @Override
        public Double visitConstantPI(LibExpParser.ConstantPIContext ctx)
        {
            return Math.PI;
        }

        @Override
        public Double visitConstantE(LibExpParser.ConstantEContext ctx)
        {
            return Math.E;
        }

        @Override
        public Double visitInt(LibExpParser.IntContext ctx)
        {
            return Double.parseDouble(ctx.INT().getText());
        }

        @Override
        public Double visitVariable(LibExpParser.VariableContext ctx)
        {
            int rowNumber = Integer.parseInt(ctx.ID().getText().replaceAll("[^0-9]", ""));
            String colLetter = ctx.ID().getText().replaceAll("[^A-Z]", "");
            if(Controller.table.get(rowNumber).get(colLetter).getStringValue().equals("Error"))
            {
                throw new NumberFormatException("Error in link formula");
            }
            return Double.parseDouble(Controller.table.get(rowNumber).get(colLetter).getStringValue());
        }

        @Override
        public Double visitDouble(LibExpParser.DoubleContext ctx)
        {
            return Double.parseDouble(ctx.DOUBLE().getText());
        }

        @Override
        public Double visitCalculate(LibExpParser.CalculateContext ctx)
        {
            return visit(ctx.logicalOperation());
        }
}


