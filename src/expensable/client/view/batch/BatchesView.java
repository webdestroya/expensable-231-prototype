package expensable.client.view.batch;

import expensable.client.mvp.Presenter;
import expensable.client.mvp.View;
import expensable.client.view.batch.BatchesView.BatchesPresenter;

public interface BatchesView extends View<BatchesPresenter> {

  interface BatchesPresenter extends Presenter {

  }

}
