import sparta.checkers.quals.*;
import sparta.checkers.quals.FlowPermission;
import java.util.*;

// TODO: I couldn't reproduce this issue in the PolyAll Checker.
//@skip-test
class MethodTypeArgumentResolution {
    void foo(List<@Source(CoarseFlowPermission.ACCESS_FINE_LOCATION) Object> l, Comparator<@Source(CoarseFlowPermission.ACCESS_FINE_LOCATION) Object> c) {
        // Unexpected incompatible type error, because method type argument is not inferred correctly.
        Collections.sort(l, c);
        // This call is/should be equivalent.
        Collections.<@Source(CoarseFlowPermission.ACCESS_FINE_LOCATION) Object>sort(l, c);
    }
}
