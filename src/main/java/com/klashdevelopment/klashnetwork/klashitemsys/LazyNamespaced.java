package com.klashdevelopment.klashnetwork.klashitemsys;

import com.destroystokyo.paper.Namespaced;
import org.jetbrains.annotations.NotNull;

public class LazyNamespaced {

    public static Namespaced of(String n, String k) {
        return new Namespaced() {
            @Override
            public @NotNull String getNamespace() {
                return n;
            }

            @Override
            public @NotNull String getKey() {
                return k;
            }
        };
    }
    public static Namespaced ofItemSys(String k) {
        return of("KlashItemSystem", k);
    }

}
