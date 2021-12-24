import { Authority } from '@/shared/security/authority';
/* tslint:disable */
// prettier-ignore

// prettier-ignore
const PedidoInterprete = () => import('@/entities/pedido-interprete/pedido-interprete.vue');
// prettier-ignore
const PedidoInterpreteDetails = () => import('@/entities/pedido-interprete/pedido-interprete-details.vue');
// prettier-ignore
const PedidoInterpreteProcessDetails = () => import('@/entities/pedido-interprete-process/pedido-interprete-process-details.vue');
// prettier-ignore
const PedidoInterpreteProcessList = () => import('@/entities/pedido-interprete-process/pedido-interprete-process-list.vue');
// prettier-ignore
const PedidoInterpreteStartFormInit = () => import('@/entities/pedido-interprete-process/pedido-interprete-start-form-init.vue');
// prettier-ignore
const PedidoInterpreteProcess_TaskPreenchePedidoDetails = () => import('@/entities/pedido-interprete-process/task-preenche-pedido/task-preenche-pedido-details.vue');
// prettier-ignore
const PedidoInterpreteProcess_TaskPreenchePedidoExecute = () => import('@/entities/pedido-interprete-process/task-preenche-pedido/task-preenche-pedido-execute.vue');
// jhipster-needle-add-entity-to-router-import - JHipster will import entities to the router here

export default [
  {
    path: '/pedido-interprete',
    name: 'PedidoInterprete',
    component: PedidoInterprete,
    meta: { authorities: [Authority.USER] },
  },
  {
    path: '/pedido-interprete/:pedidoInterpreteId/view',
    name: 'PedidoInterpreteView',
    component: PedidoInterpreteDetails,
    meta: { authorities: [Authority.USER] },
  },
  {
    path: '/process-definition/PedidoInterpreteProcess/instance/:processInstanceId/view',
    name: 'PedidoInterpreteProcessView',
    component: PedidoInterpreteProcessDetails,
    meta: { authorities: [Authority.USER] },
  },
  {
    path: '/process-definition/PedidoInterpreteProcess/instances',
    name: 'PedidoInterpreteProcessList',
    component: PedidoInterpreteProcessList,
    meta: { authorities: [Authority.USER] },
  },
  {
    path: '/process-definition/PedidoInterpreteProcess/init',
    name: 'PedidoInterpreteStartFormInit',
    component: PedidoInterpreteStartFormInit,
    meta: { authorities: [Authority.USER] },
  },
  {
    path: '/process-definition/PedidoInterpreteProcess/task/PedidoInterprete/:taskInstanceId/view',
    name: 'PedidoInterpreteProcess_TaskPreenchePedidoDetails',
    component: PedidoInterpreteProcess_TaskPreenchePedidoDetails,
    meta: { authorities: [Authority.USER] },
  },
  {
    path: '/process-definition/PedidoInterpreteProcess/task/PedidoInterprete/:taskInstanceId/execute',
    name: 'PedidoInterpreteProcess_TaskPreenchePedidoExecute',
    component: PedidoInterpreteProcess_TaskPreenchePedidoExecute,
    meta: { authorities: [Authority.USER] },
  },
  // jhipster-needle-add-entity-to-router - JHipster will add entities to the router here
];
