package io.fotoapparat.lens;

/**
 * The result of an attempt to lock the focus.
 */
public class FocusResultState {

    /**
     * {@code True} if the camera succeeded to lock the focus.
     */
    public final boolean succeeded;
    /**
     * {@code True} if the camera needs to perform an exposure measurement.
     */
    public final boolean needsExposureMeasurement;

    public FocusResultState(boolean succeeded, boolean needsExposureMeasurement) {
        this.succeeded = succeeded;
        this.needsExposureMeasurement = needsExposureMeasurement;
    }

    /**
     * Creates a new instance which has neither succeeded nor needs exposure measurement.
     *
     * @return A new, invalid {@link FocusResultState}
     */
    public static FocusResultState none() {
        return new FocusResultState(false, false);
    }

    /**
     * Creates a new instance which has succeeded but doesn't need exposure measurement.
     *
     * @return A new {@link FocusResultState}
     */
    public static FocusResultState successNoMeasurement() {
        return new FocusResultState(true, false);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        FocusResultState that = (FocusResultState) o;

        if (succeeded != that.succeeded) return false;
        return needsExposureMeasurement == that.needsExposureMeasurement;

    }

    @Override
    public int hashCode() {
        int result = (succeeded ? 1 : 0);
        result = 31 * result + (needsExposureMeasurement ? 1 : 0);
        return result;
    }
}
