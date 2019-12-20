package cn.cement.ysh.coderecord.utils;

import org.apache.hadoop.hbase.io.ImmutableBytesWritable;
import org.apache.phoenix.expression.Expression;
import org.apache.phoenix.expression.function.DateScalarFunction;
import org.apache.phoenix.parse.FunctionParseNode;
import org.apache.phoenix.schema.tuple.Tuple;
import org.apache.phoenix.schema.types.PDataType;
import org.apache.phoenix.schema.types.PTimestamp;
import org.apache.phoenix.schema.types.PVarchar;

import java.time.LocalDate;


/*
 * @Description: 季节自定义函数，根据一个日期类型日期，返回一个字符串类型季节
 * @Auther: gucp
 * @Date: 2019/1/2 16:11
 *
 */
@FunctionParseNode.BuiltInFunction(
        name = "QUARTER",
        args = {@FunctionParseNode.Argument(
                allowedTypes = {PTimestamp.class}
        )}
)
public class DfQuarter extends DateScalarFunction {
    public static final String NAME = "QUARTER";


    public boolean evaluate(Tuple tuple, ImmutableBytesWritable immutableBytesWritable) {
        Expression expression = getExpression();
        if (!expression.evaluate(tuple, immutableBytesWritable)) {
            return false;
        }
        if (immutableBytesWritable.getLength() == 0) {
            return true;
        }
        long dateTime = this.inputCodec.decodeLong(immutableBytesWritable, expression.getSortOrder());
        LocalDate localDate = LocalDate.ofEpochDay(dateTime);
        int intYear = localDate.getYear();
        int intMonth = localDate.getMonth().getValue();


        byte[] byteValue = (intYear + "第" + intMonth/4 + "季度").getBytes();


        immutableBytesWritable.set(byteValue);
        return true;


    }


    public String getName() {
        return NAME;
    }

    public PDataType getDataType() {
        return PVarchar.INSTANCE;
    }

    public Expression getExpression(){
        return this.getChildren().get(0);
    }

}