package emuns;

import lombok.Getter;

@Getter
public enum FilterStatus {
    DISABLED("Disabled"),
    ENABLED("Enabled");

    public String var;

    FilterStatus(String var) {
        this.var = var;
    }

    public static FilterStatus getItemFilter(String filterStatus) {
        for (FilterStatus filter : FilterStatus.values()) {
            if (filter.getVar().equalsIgnoreCase(filterStatus)) {
                return filter;
            }
        }
        throw new IllegalStateException("Wrong parameter passed");
    }
}
