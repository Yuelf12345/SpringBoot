import MessageBoxConstructor from "./MessageBox.vue";
import { createVNode, render } from "vue";
import type { AppContext, ComponentPublicInstance } from "vue";
import type { Action, Callback } from "./message-box.type";

const messageInstance = new Map<
  ComponentPublicInstance<{ doClose: () => void }>,
  {
    options: any;
    callback: Callback | undefined;
    resolve: (res: any) => void;
    reject: (reason?: any) => void;
  }
>();
const getAppendToElement = (props: any): HTMLElement => {
  let appendTo: HTMLElement = document.body;
  if (props.appendTo) {
    if (props.appendTo === "string") {
      appendTo = document.querySelector(props.appendTo);
    } else {
      appendTo = document.body;
    }
  }
  return appendTo;
};
const initInstance = (
  props: any,
  container: HTMLElement,
  appContext: AppContext | null = null
) => {
  const vnode = createVNode(MessageBoxConstructor, props);
  vnode.appContext = appContext;
  render(vnode, container);
  getAppendToElement(props).appendChild(container.firstElementChild!);
  return vnode.component;
};
const hasOwn = (val: object, key: string) =>
  Object.prototype.hasOwnProperty.call(val, key);
const genContainer = () => {
  return document.createElement("div");
};
const showMessage = (options: any, appContext?: AppContext | null) => {
  const container = genContainer();
  options.onAction = (action: Action) => {
    const currentMsg = messageInstance.get(vm)!;
    console.log("action", action);
    let resolve: Action | { value: string; action: Action };
    resolve = action;
    if (options.callback) {
      options.callback(resolve, instance.proxy);
    } else {
      if (action === "cancel" || action === "close") {
        if (options.distinguishCancelAndClose && action !== "cancel") {
          currentMsg.reject("close");
        } else {
          currentMsg.reject("cancel");
        }
      } else {
        currentMsg.resolve(resolve);
      }
    }
  };

  const instance = initInstance(options, container, appContext)!;
  const vm = instance.proxy as ComponentPublicInstance<
    {
      visible: boolean;
      doClose: () => void;
    } & any
  >;
  for (const prop in options) {
    if (hasOwn(options, prop) && !hasOwn(vm.$props, prop)) {
      vm[prop as keyof ComponentPublicInstance] = options[prop];
    }
  }
  //   vm.visible = true;
  return vm;
};

async function MessageBox(options: any, appContext?: AppContext | null) {
  let callback: Callback | undefined;
  return new Promise((resolve, reject) => {
    const vm = showMessage(options, appContext);
    messageInstance.set(vm, {
      options,
      callback,
      resolve,
      reject,
    });
  });
}

export default MessageBox;
