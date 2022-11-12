package com.klashdevelopment.klashnetwork.klashitemsys;

import com.destroystokyo.paper.Namespaced;
import org.bukkit.NamespacedKey;
import org.jetbrains.annotations.NotNull;

public class LazyNamespaced {

    public static Namespaced of(String n, String k) {
        System.out.println("K: " + k + " N: " + n);
        return new NamespacedKey(n, k);
    }
    public static Namespaced ofItemSys(String k) {
        System.out.println(k);
        return of("klash", k);
    }

}
