package org.sajt.service.util;

import java.util.Optional;

public interface ChainItem<T> {
    T setNextChainItem(T item);
    Optional<T> getNextChainItem();
}
