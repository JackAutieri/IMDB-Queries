/**
 * @author Jack Autieri
 * @description This interface defines a command pattern structure for executing actions.
 * Classes implementing this interface must provide an implementation of the `execute` method.
 */

package movie;

public interface Command {
    /**
     * Executes the command.
     * This method is intended to encapsulate and perform a specific action
     * when called by a client.
     */
    void execute();
}
