package rs.ac.ni.pmf.oop3.vezbe.vezba07.Hiking;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import rs.ac.ni.pmf.oop3.vezbe.WaitUtil;

import java.util.List;

@Slf4j
public class Hiker implements Runnable {
    private final String _name;
    private final List<HikingField> _hikingFields;
    private final long _timeout;
    private int _currentField;
    public Hiker(final List<HikingField> hikingFields, final String name, final int startingField, final long timeout) {
        _name = name;
        _currentField = startingField;
        _hikingFields = hikingFields;
        _timeout = timeout;

        _hikingFields.get(_currentField).getQueue().add(_name);
    }

    @Override
    public void run() {
        while(_currentField < _hikingFields.size() - 1) {
            // free the current field
            _hikingFields.get(_currentField).getQueue().remove();
            WaitUtil.sleep(_timeout);
            try {
                _hikingFields.get(++_currentField).getQueue().put(_name);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            log.info("Hiker {} is on field {}", _name, _currentField);
        }
        log.info("Hiker {} has finished climbing", _name);
    }
}
