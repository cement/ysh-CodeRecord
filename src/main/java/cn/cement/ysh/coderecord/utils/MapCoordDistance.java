package cn.cement.ysh.coderecord.utils;

import org.apache.hadoop.hbase.io.ImmutableBytesWritable;
import org.apache.phoenix.expression.Expression;
import org.apache.phoenix.expression.function.ScalarFunction;
import org.apache.phoenix.schema.tuple.Tuple;
import org.apache.phoenix.schema.types.PDataType;
import org.apache.phoenix.schema.types.PDouble;

import java.util.List;

public class MapCoordDistance extends ScalarFunction {
    @Override
    public String getName() {
        return null;
    }

    @Override
    public boolean evaluate(Tuple tuple, ImmutableBytesWritable immutableBytesWritable) {
        if (immutableBytesWritable.getLength() == 0) {
            return true;
        }
        List<Expression> childrens = this.getChildren();
        for (int i = 0; i < childrens.size(); i++) {
            Expression expression = childrens.get(i);
            if (!expression.evaluate(tuple, immutableBytesWritable)) {
                return false;
            }
        }

        Double longitudeA = this.getLiteralValue(0, double.class);
        Double latitudeA = this.getLiteralValue(1, double.class);
        Double longitudeB = this.getLiteralValue(2, double.class);
        Double latitudeB = this.getLiteralValue(3, double.class);


        double a2 = Math.toRadians(longitudeA);
        double a1 = Math.toRadians(latitudeA);
        double b2 = Math.toRadians(longitudeB);
        double b1 = Math.toRadians(latitudeB);
        double t1 = Math.cos(a1) * Math.cos(a2) * Math.cos(b1) * Math.cos(b2);
        double t2 = Math.cos(a1) * Math.sin(a2) * Math.cos(b1) * Math.sin(b2);
        double t3 = Math.sin(a1) * Math.sin(b1);
        double tt = Math.acos(t1 + t2 + t3);
        double distance = 6371000 * tt;
        immutableBytesWritable.set(PDouble.INSTANCE.toBytes(distance,getSortOrder()));

        return true;
    }

    @Override
    public PDataType getDataType() {
        return PDouble.INSTANCE;
    }

    public Expression getExpression(){
        return this.getChildren().get(0);
    }



}
