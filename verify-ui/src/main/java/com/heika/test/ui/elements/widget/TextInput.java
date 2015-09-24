package com.heika.test.ui.elements.widget;

import com.heika.test.ui.elements.base.Element;
import com.heika.test.ui.elements.base.ImplementedBy;

/**
 * Text field functionality.
 */
@ImplementedBy(TextInputImpl.class)
public interface TextInput extends Element {
    /**
     * @param text The text to type into the field.
     */
    void set(String text);
}
