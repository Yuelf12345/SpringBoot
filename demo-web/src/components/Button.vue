<template>
  <button :class="buttonClass">
    <slot>按钮</slot>
  </button>
</template>

<script>
export default {
  name: 'YButton',
  props: {
    type: {
      type: String,
      default: 'default',
      validator: value => ['default', 'primary', 'info', 'success', 'warning', 'danger'].includes(value)
    }
  },
  computed: {
    buttonClass() {
      return ['y-button', `y-button--${this.type}`];
    }
  }
}
</script>
<style scoped lang="scss">

</style>