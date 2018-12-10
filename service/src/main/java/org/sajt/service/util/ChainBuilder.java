package org.sajt.service.util;

import java.util.Optional;

public class ChainBuilder<T extends ChainItem<T>> {

    private T firstItemInChain = null;
    private T lastItemInChain = null;

    public ChainBuilder<T> withNext(T item) {
        if (firstItemInChain == null) {
            firstItemInChain = item;
        }
        if (lastItemInChain == null) {
            lastItemInChain = item;
        } else {
            lastItemInChain.setNextChainItem(item);
        }
        return this;
    }

    public Optional<T> build() {
        return Optional.ofNullable(firstItemInChain);
    }
}
