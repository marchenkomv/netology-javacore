package task_1_1_2;

@FunctionalInterface
public interface OnTaskErrorListener {
    void onError(String result);
}
